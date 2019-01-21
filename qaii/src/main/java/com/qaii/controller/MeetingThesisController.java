package com.qaii.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.qaii.domain.MeetingThesisAuthor;
import com.qaii.service.MeetingThesisAuthorService;
import com.qaii.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qaii.domain.MeetingThesis;
import com.qaii.domain.MeetingThesisFile;
import com.qaii.service.MeetingThesisFileService;
import com.qaii.service.MeetingThesisService;

@Controller
public class MeetingThesisController {

    @Resource
    private MeetingThesisService Service;
    @Resource
    private MeetingThesisFileService fileService;
    @Resource
    private MeetingThesisAuthorService authorService;

    //文件路径
    public final static String FILE_PATH = "C:/File/img/MeetingThesis/";
    //数据库中记录的路径
    public final static String DATABASE_PATH = "/img/MeetingThesis/";

    public final static byte BYTE_TRUE = 1;

    public final static byte BYTE_FALSE = 0;

    //查看所有信息
    @RequestMapping(value = "listMeeting.do", method = RequestMethod.POST)
    @ResponseBody
    Layui listMeetingThesis() {
        List<MeetingThesis> result = Service.listAllMessage();
        int count = result.size();
        if (count > 0) {
            return Layui.data(count, result);
        } else {
            return Layui.data(count, null);
        }
    }

    //删除信息
    @RequestMapping(value = "deleteMeeting.do", method = RequestMethod.POST)
    @ResponseBody
    JsonResult deleteMessages(@RequestParam("requestDate[]") Integer[] id) {
        int result = Service.deleteMessages(id);
        if (result > 0) {
            return new JsonResult(result);
        } else {
            return new JsonResult();
        }
    }

    //查看详情
    @RequestMapping(value = "getMeeting.do", method = RequestMethod.POST)
    @ResponseBody
    JsonResult getMessage(HttpServletRequest req) {
        MeetingThesis result = Service.getMessage(Long.parseLong(req.getParameter("id")));
        if (!result.equals(null)) {
            return new JsonResult(result);
        } else {
            return new JsonResult();
        }
    }

    //修改信息
    @RequestMapping(value = "updateMeeting.do", method = RequestMethod.POST)
    String updateMessage(HttpServletRequest req,
                         MeetingThesis record,
                         @RequestParam("file") MultipartFile[] files) throws AlertException {
        loadData(req, record);
        record.setGmtModified(new Date());
        record.setId(Long.parseLong(req.getParameter("id")));
        int recordResult = Service.updateMessage(record);
        updateFile(record, files);
        if (recordResult > 0) {
            return "page/science/inform/edit-succesdsci";
        } else {
            return "page/science/inform/edit-faildsci";
        }
    }

    int updateFile(MeetingThesis record, MultipartFile[] files) {
        // TODO Auto-generated method stub
        if (files.equals(null) && files.length < 0) {
            return 0;
        }
        if (files[0].getSize() == 0)
            return 0;
        MeetingThesisFile file = new MeetingThesisFile();
        for (int i = 0; i < files.length; i++) {

            //文件类型
            String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
            //文件名
            String name = files[i].getOriginalFilename();
            //新的文件名前缀（取时间戳）
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //新的文件名
            String filename = uuid + type;

            String path = (FILE_PATH + record.getMeetingName() + "/other/");
            String dbpath = (DATABASE_PATH + record.getMeetingName() + "/other/");
            File demoFile = new File(path + filename);
            file.setTid(record.getId());
            file.setStyle("other");
            file.setName(name);
            file.setPath(dbpath + filename);
            if (!demoFile.getParentFile().exists()) {
                demoFile.getParentFile().mkdirs();
            }
            try {
                //保存文件
                files[i].transferTo(demoFile);
                //在数据库中插入文件信息
                fileService.insertMessage(file);
            } catch (Exception e) {
                return 0;
            }

        }
        return 1;
    }

    void loadData(HttpServletRequest req, MeetingThesis record) {
        record.setTopic(req.getParameter("topic"));
        record.setAuthor(req.getParameter("author"));
        record.setAuthorUnit(req.getParameter("authorUnit"));
        record.setPublishtime(req.getParameter("publishtime"));
        record.setMeetingName(req.getParameter("meetingName"));
        record.setMeetingLocation(req.getParameter("meetingLocation"));
        record.setKeyword(req.getParameter("keyword"));
        record.setCommunicateAuthor(req.getParameter("communicateAuthor"));
        record.setEnglishSummary(req.getParameter("englishSummary"));
        record.setMeetingRecord(req.getParameter("meetingRecord"));
        record.setContentType(req.getParameter("contentType"));
        record.setUnit(req.getParameter("unit"));
        record.setGmtModified(new Date());
    }

    //添加记录
    @RequestMapping(value = "insertMeeting.do", method = RequestMethod.POST)
    String insertMessage(HttpServletRequest req,
                         MeetingThesis record,
                         @RequestParam("patRemission") String[] level,
                         @RequestParam("shareholderName") String[] authorName,
                         @RequestParam("contributionTime") String[] authorUnit,
                         @RequestParam("file") MultipartFile[] files) throws CustomException {
        record.setGmtCreate(new Date());
        record.setIsPass(BYTE_FALSE);
        loadData(req, record);
        int insertResult = Service.insertMessage(record);
        insertAuthor(level, authorName, authorUnit, record.getId().toString());
        insertFile(record, files);
        if (insertResult > 0) {
            return "page/science/inform/add-succesdOut";
        } else {
            return "page/science/inform/add-faildOut";
        }
    }

    //在插入的时候同时插入作者信息
    void insertAuthor(String[] level, String[] name, String[] unit, String id) {
        MeetingThesisAuthor author = new MeetingThesisAuthor();
        author.setAuthorRemark(id);
        for (int i = 0; i < name.length; i++) {
            author.setAuthorLevel(level[i]);
            author.setAuthorName(name[i]);
            author.setAuthorUnit(unit[i]);
            authorService.inset(author);
        }
    }

    int insertFile(MeetingThesis record, MultipartFile[] files) throws CustomException {
        // TODO Auto-generated method stub
        if (files[0].isEmpty() || files.length < 1) {
            Service.deleteMessages(new Integer[]{(record.getId()).intValue()});
            throw new CustomException("电子版文件不能为空!");
        }
        if (files[1].isEmpty()) {
            MeetingThesisFile file = new MeetingThesisFile();
            file.setPath("null");
            file.setName("null");
            file.setStyle("certified");
            file.setTid(record.getId());
            fileService.insertMessage(file);
        }
        if (files[0].getSize() == 0)
            return 0;
        MeetingThesisFile file = new MeetingThesisFile();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isEmpty())
                continue;
            //文件类型
            String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
            //文件名
            String name = files[i].getOriginalFilename();
            //新的文件名前缀（取时间戳）
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //新的文件名
            String filename = uuid + type;

            //在正常情况下，文件队列的第一个应该是电子文件，第二个是证明文件，剩余为其他文件
            if (i <= 1) {
                String path = (i == 0 ? FILE_PATH + record.getMeetingName() + "/electronic/" : FILE_PATH + record.getMeetingName() + "/certified/");
                String dbpath = (i == 0 ? DATABASE_PATH + record.getMeetingName() + "/electronic/" : DATABASE_PATH + record.getMeetingName() + "/certified/");
                String style = (i == 0 ? "electronic" : "certified");
                long t = record.getId();
                file.setTid(record.getId());
                file.setStyle(style);
                file.setName(name);
                file.setPath(dbpath + filename);
                File demoFile = new File(path + filename);
                if (!demoFile.getParentFile().exists()) {
                    demoFile.getParentFile().mkdirs();
                }
                try {
                    //保存文件
                    files[i].transferTo(demoFile);
                    //在数据库中插入文件信息
                    fileService.insertMessage(file);
                } catch (Exception e) {
                    return 0;
                }
                continue;
            }

            String path = (FILE_PATH + record.getMeetingName() + "/other/");
            String dbpath = (DATABASE_PATH + record.getMeetingName() + "/other/");
            File demoFile = new File(path + filename);
            file.setTid(record.getId());
            file.setStyle("other");
            file.setName(name);
            file.setPath(dbpath + filename);
            if (!demoFile.getParentFile().exists()) {
                demoFile.getParentFile().mkdirs();
            }
            try {
                //保存文件
                files[i].transferTo(demoFile);
                //在数据库中插入文件信息
                fileService.insertMessage(file);
            } catch (Exception e) {
                return 0;
            }

        }
        return 1;
    }

    //文件重新上传
    @RequestMapping(value = "fileReupMeeting.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    String fileReup(HttpServletRequest req,
                    MeetingThesisFile record,
                    @RequestParam("file") MultipartFile files
    ) {
        String topic = req.getParameter("topic");
        String style = req.getParameter("style");
        record.setName(files.getOriginalFilename());
        try {
            File file = new File(FILE_PATH + req.getParameter("address"));
            if (file.exists()) {
                file.delete();
            }
            //文件后缀
            String type = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf("."));
            //新的文件名
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String filename = uuid + type;
            //文件的本地绝对路径
            String filepath = FILE_PATH + topic + "/" + style + "/" + filename;
            //文件存放于数据库中的相对路径
            String dbpath = DATABASE_PATH + topic + "/" + style + "/" + filename;
            record.setPath(dbpath);
            file = new File(filepath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            if (!"".equals(req.getParameter("id"))) {
                record.setId(Long.parseLong(req.getParameter("id")));
                files.transferTo(file);
                fileService.updateMessage(record);
            } else {
                record.setTid(Long.valueOf(req.getParameter("tid")));
                record.setStyle(style);
                fileService.insertMessage(record);
            }

            return "文件上传成功!";
        } catch (Exception e) {
            return "文件上传失败!";
        }
    }

    //删除文件接口
    @RequestMapping(value = "deleteFileMeeting.do", method = RequestMethod.POST)
    @ResponseBody
    JsonResult deleteFile(HttpServletRequest req, @RequestParam("id") long id, @RequestParam("address") String address) {
        try {
            File file = new File(FILE_PATH + address);
            if (file.exists()) {
                file.delete();
            }
            Object obj = fileService.deleteMessage(id);
            return new JsonResult(obj);
        } catch (Exception e) {
            return new JsonResult();
        }
    }

    //未审核的记录列表
    @RequestMapping(value = "listNotPassMeeting.do", method = RequestMethod.POST)
    @ResponseBody
    Layui listNotPass() {
        List<MeetingThesis> result = Service.listNotPass();
        return Layui.data(1, result);
    }

    //通过申请
    @RequestMapping(value = "setPassMeeting.do", method = RequestMethod.POST)
    @ResponseBody
    JsonResult setPass(HttpServletRequest req, MeetingThesis record) {
        record.setId(Long.valueOf(req.getParameter("id")));
        record.setIsPass(BYTE_TRUE);
        int result = Service.updateMessage(record);
        return new JsonResult(result);
    }

    //导入
    @RequestMapping(value = "insertMeetingByExcel.do")
    @ResponseBody
    public JsonResult insertByExcel(@RequestParam("file") MultipartFile file, MeetingThesis record, MeetingThesisFile recordfile) throws FileNotFoundException, IOException, CustomException, AlertException {
        List<String> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String filename = file.getOriginalFilename();
        recordfile.setName("null");
        recordfile.setPath("null");
        Workbook wookbook;
        //判断是不是excel文件
        if (!(filename.endsWith(".xls") || filename.endsWith(".xlsx")))
            throw new AlertException("请选择excel格式的文件！");
        //判断是03版还是07版excel
        if (filename.endsWith(".xls")) {
            wookbook = new HSSFWorkbook(file.getInputStream());
        } else {
            wookbook = new XSSFWorkbook(file.getInputStream());
        }
        try {
            Sheet sheet = wookbook.getSheet("Sheet1");
            int rows = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                int cells = sheet.getRow(0).getPhysicalNumberOfCells();
                if (row != null) {
                    list.clear();
                    for (int j = 0; j < cells; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            int cellType = cell.getCellType();
                            switch (cellType) {
                                case Cell.CELL_TYPE_BLANK:    //单元格式为空白
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN: //布尔
                                    cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
                                    break;
                                case Cell.CELL_TYPE_ERROR:    //错误
                                    cell.setCellValue("错误");
                                    break;
                                case Cell.CELL_TYPE_FORMULA: //公式
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:    //日期、数字
                                    if (DateUtil.isCellDateFormatted(cell))
                                        cell.setCellValue(sdf.format(cell.getDateCellValue()));
                                    else {
                                        cell.setCellType(Cell.CELL_TYPE_STRING);
                                    }
                                    break;
                                case Cell.CELL_TYPE_STRING:        //文本
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                            }
                            list.add(cell.toString());
                        } else {
                            list.add(null);
                        }
                    }
                    record.setId(null);
                    loadExcelData(record, list);
                    Service.insertMessage(record);
                    recordfile.setTid(record.getId());
                    recordfile.setStyle("electronic");
                    fileService.insertMessage(recordfile);
                    recordfile.setStyle("certified");
                    fileService.insertMessage(recordfile);
                }
            }
        } catch (Exception e) {
            wookbook.close();
            e.printStackTrace();
            throw new CustomException("数据库异常!请检查文件格式!");
        }
        wookbook.close();
        return new JsonResult("success");

    }

    void loadExcelData(MeetingThesis record, List<String> list) {
        // TODO Auto-generated method stub
        record.setTopic(list.get(0));
        record.setAuthor(list.get(1));
        record.setAuthorUnit(list.get(2));
        record.setPublishtime(list.get(3));
        record.setMeetingName(list.get(4));
        record.setMeetingLocation(list.get(5));
        record.setKeyword(list.get(6));
        record.setCommunicateAuthor(list.get(7));
        record.setEnglishSummary(list.get(8));
        record.setMeetingRecord(list.get(9));
        record.setContentType(list.get(10));
        record.setUnit(list.get(11));
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        record.setIsPass(BYTE_TRUE);
    }

    //作者添加
    @RequestMapping(value = "addMeetingAuthor.do")
    String addMeetingAuthor(@RequestParam("shareholderName") String name, @RequestParam("patRemission") String level, @RequestParam("contributionTime") String unit, @RequestParam("id") String id, MeetingThesisAuthor Record) {
        Record.setAuthorName(name);
        Record.setAuthorLevel(level);
        Record.setAuthorUnit(unit);
        Record.setAuthorRemark(id);
        Record.setId(null);
        if (authorService.inset(Record) == 1) {
            return ConstantUtil.SCIENCE_INSERT_SUCCESS;
        } else {
            return ConstantUtil.SCIENCE_INSERT_FAILD;
        }
    }

    //显示作者
    @RequestMapping("listMeetingAuthor.do")
    @ResponseBody
    Layui listMeetingAuthor(@RequestParam("id") String id) {
        List<MeetingThesisAuthor> result = authorService.listAuthor(id);
        return Layui.data(result.size(), result);
    }

    //删除作者
    @RequestMapping("deleteMeetingAuthor.do")
    @ResponseBody
    JsonResult deleteMeetingAuthor(@RequestParam("id") Integer[] id) {
        int result = authorService.delete(id);
        if (result != 0) {
            return new JsonResult(result);
        } else {
            return new JsonResult();
        }
    }
}
