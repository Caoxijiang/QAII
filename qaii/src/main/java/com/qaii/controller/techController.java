package com.qaii.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.DeptInfo;
import com.qaii.domain.EmpInfo;
import com.qaii.service.DeptInfoService;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class techController {
	//主框架
	@RequestMapping("science.do")
	public String science(){
		return "page/science/science";
	}
	//科技处数据可视化
	@RequestMapping("indexScience.do")
	public String indexScience(){
		return "page/science/indexScience";
	}
	//专利
	@RequestMapping("patent.do")
	public String patent(){
		return "page/science/patent/patent";
	}
	//专利添加界面
		@RequestMapping("patentAdd.do")
		public String patentAdd(){
			return "page/science/patent/patentAdd";
		}
	//专利查看详情界面
		@RequestMapping("patentCheck.do")
		public String patentCheck(){
			return "page/science/patent/patentCheck";
	}
	//专利修改界面
	@RequestMapping("patentEdit.do")
	public String patentEdit(){
		return "page/science/patent/patentEdit";
	}
	//专利资料审查界面
	@RequestMapping("patentProcess.do")
	public String patentProcess(){
		return "page/science/patent/patentProcess";
	}
	//专利文件重新上传
	@RequestMapping("patentfilereload.do")
	public ModelAndView patentfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("userID").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("step").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("pat").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/patent/patentfilereload", "utflist", result);
	}
	//专利资料审查文件预览界面
	@RequestMapping("patentData.do")
	public ModelAndView patentData(@Param("patName")String patName, 
			@Param("patAuthor")String patAuthor, 
			@Param("patPublishtime")String patPublishtime, 
			@Param("userId")String userId, 
			HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(patName.getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(patAuthor.getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(patPublishtime.getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(userId.getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/patent/patentData", "utflist", result);
	}
	//专利资料审查文件流程添加界面
	@RequestMapping("patentDataAdd.do")
	public String patentDataAdd(){
		return "page/science/patent/patentDataAdd";
	}
	//专利资料审查文件添加界面
	@RequestMapping("patentDataAddFile.do")
	public String patentDataAddFile(){
		return "page/science/patent/patentDataAddFile";
	}
	//软著
	@RequestMapping("soft.do")
	public String soft(){
		return "page/science/soft/soft";
	}
	//软著添加
	@RequestMapping("softAdd.do")
	public String softAdd(){
		return "page/science/soft/softAdd";
	}
	//软著修改
	@RequestMapping("softEdit.do")
	public String softEdit(){
		return "page/science/soft/softEdit";
	}
	//软著查看
	@RequestMapping("softCheck.do")
	public String softCheck(){
		return "page/science/soft/softCheck";
	}
	//软著文件重新上传
	@RequestMapping("softfilereload.do")
	public ModelAndView softfilereload(@Param("softName")String softName, @Param("address")String address, @Param("sid")String sid, HttpServletRequest request ) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(softName.getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(address.getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(sid.getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/soft/softfilereload", "utflist", result);
	}
	//软著多文件重新上传
	@RequestMapping("softfilereloadadd.do")
	public ModelAndView softfilereloadadd(@Param("id")String id, @Param("softName")String softName, @Param("address")String address, HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(id.getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(softName.getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(address.getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/soft/softfilereloadadd", "utflist", result);
	}
	//商标
	@RequestMapping("brand.do")
	public String brand() {
		return "page/science/brand/brand";
	}
	//商标添加界面
	@RequestMapping("brandAdd.do")
	public String brandAdd(){
		return "page/science/brand/brandAdd";
	}
	//商标查看详情界面
	@RequestMapping("brandCheck.do")
	public String brandCheck(){
		return "page/science/brand/brandCheck";
	}
	//商标修改界面
	@RequestMapping("brandEdit.do")
	public String brandEdit(){
		return "page/science/brand/brandEdit";
	}
	//商标资料审查界面
	@RequestMapping("brandProcess.do")
	public ModelAndView brandProcess(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("tradmDept").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmApplyper").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmRegistertime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/brand/brandProcess", "utflist", result);
	}
	//商标资料审查文件预览界面
	@RequestMapping("brandData.do")
	public ModelAndView brandData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("tradmDept").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmApplyper").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmRegistertime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/brand/brandData", "utflist", result);
	}
	//商标资料审查文件流程添加界面
	@RequestMapping("brandDataAdd.do")
	public String brandDataAdd(){
		return "page/science/brand/brandDataAdd";
	}
	//商标资料审查文件添加界面
	@RequestMapping("brandDataAddFile.do")
	public String brandDataAddFile(){
		return "page/science/brand/brandDataAddFile";
	}
	//商标文件重新上传
	@RequestMapping("brandfilereload.do")
	public ModelAndView brandfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("userID").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("step").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tradmDept").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/brand/brandfilereload", "utflist", result);
	}
	//版权
	@RequestMapping("copyright.do")
	public String copyright() {
		return "page/science/copyright/copyright";
	}
	//版权添加
	@RequestMapping("copyrightAdd.do")
	public String copyrightAdd() {
		return "page/science/copyright/copyrightAdd";
	}
	//版权查看详情
	@RequestMapping("copyrightCheck.do")
	public String copyrightCheck() {
		return "page/science/copyright/copyrightCheck";
	}
	//版权修改
	@RequestMapping("copyrightEdit.do")
	public String copyrightEdit() {
		return "page/science/copyright/copyrightEdit";
	}
	//基金
	@RequestMapping("fund.do")
	public String fund(){
		return "page/science/fund/fund";
	}
	//基金添加界面
	@RequestMapping("fundAdd.do")
	public String fundAdd(){
		return "page/science/fund/fundAdd";
	}
	//基金查看详情界面
	@RequestMapping("fundCheck.do")
	public String fundCheck(){
		return "page/science/fund/fundCheck";
	}
	//基金修改界面
	@RequestMapping("fundEdit.do")
	public String fundEdit(){
		return "page/science/fund/fundEdit";
	}
	//基金资料审查界面
	@RequestMapping("fundProcess.do")
	public ModelAndView fundProcess(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("govfundName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govfundSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govfundApplytime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/fund/fundProcess", "utflist", result);
	}
	//基金重新上传界面
	@RequestMapping("fundfilereload.do")
	public ModelAndView fundfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("userID").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("step").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("pat").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/fund/fundfilereload", "utflist", result);
	}
	//基金资料审查文件预览界面
	@RequestMapping("fundData.do")
	public ModelAndView fundData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("govfundName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govfundSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govfundApplytime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/fund/fundData", "utflist", result);
	}
	//基金资料审查文件流程添加界面
	@RequestMapping("fundDataAdd.do")
	public String fundDataAdd(){
		return "page/science/fund/fundDataAdd";
	}
	//基金资料审查文件添加界面
	@RequestMapping("fundDataAddFile.do")
	public String fundDataAddFile(){
		return "page/science/fund/fundDataAddFile";
	}
	
	//创新平台
	@RequestMapping("create.do")
	public String create(){
		return "page/science/create/create";
	}
	//创新平台添加界面
	@RequestMapping("createAdd.do")
	public String createAdd(){
		return "page/science/create/createAdd";
	}
	//创新平台查看详情界面
	@RequestMapping("createCheck.do")
	public String createCheck(){
		return "page/science/create/createCheck";
	}
	//创新平台修改界面
	@RequestMapping("createEdit.do")
	public String createEdit(){
		return "page/science/create/createEdit";
	}
	//创新平台资料审查界面
	@RequestMapping("createProcess.do")
	public ModelAndView createProcess(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("govplatName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govplatSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govplatApprovalnum").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/create/createProcess", "utflist", result);
	}
	//创新平台文件重新上传
	@RequestMapping("createfilereload.do")
	public ModelAndView createfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("userID").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("step").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govplatName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/create/createfilereload", "utflist", result);
	}
	//创新平台资料审查文件预览界面
	@RequestMapping("createData.do")
	public ModelAndView createData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("govplatName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govplatSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govplatApprovalnum").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/create/createData", "utflist", result);
	}
	//创新平台资料审查文件流程添加界面
	@RequestMapping("createDataAdd.do")
	public String createDataAdd(){
		return "page/science/create/createDataAdd";
	}
	//创新平台资料审查文件添加界面
	@RequestMapping("createDataAddFile.do")
	public String createDataAddFile(){
		return "page/science/create/createDataAddFile";
	}
		
	//纵向课题
	@RequestMapping("research.do")
	public String research(){
		return "page/science/research/research";
	}
	//纵向课题添加界面
	@RequestMapping("researchAdd.do")
	public String researchAdd(){
		return "page/science/research/researchAdd";
	}
	//纵向课题查看详情界面
	@RequestMapping("researchCheck.do")
	public String researchCheck(){
		return "page/science/research/researchCheck";
	}
	//纵向课题修改界面
	@RequestMapping("researchEdit.do")
	public String researchEdit(){
		return "page/science/research/researchEdit";
	}
	//纵向课题重现上传
	@RequestMapping("researchfilereload.do")
	public ModelAndView researchfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("userID").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("step").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govsubName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/research/researchfilereload", "utflist", result);
	}
	//纵向课题资料审查界面
	@RequestMapping("researchProcess.do")
	public ModelAndView researchProcess(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("govsubName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govsubSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govsubApprovalnum").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/research/researchProcess", "utflist", result);
	}
	//纵向课题资料审查文件预览界面
	@RequestMapping("researchData.do")
	public ModelAndView researchData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("govsubName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govsubSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("govsubApprovalnum").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/research/researchData", "utflist", result);
	}
	//纵向课题资料审查文件流程添加界面
	@RequestMapping("researchDataAdd.do")
	public String researchDataAdd(){
		return "page/science/research/researchDataAdd";
	}
	//纵向课题资料审查文件添加界面
	@RequestMapping("researchDataAddFile.do")
	public String researchDataAddFile(){
		return "page/science/research/researchDataAddFile";
	}
	//科技奖励
	@RequestMapping("award.do")
	public String award(){
		return "page/science/award/award";
	}
	//科技奖励添加界面
	@RequestMapping("awardAdd.do")
	public String awardAdd(){
		return "page/science/award/awardAdd";
	}
	//科技奖励查看详情界面
	@RequestMapping("awardCheck.do")
	public String awardCheck(){
		return "page/science/award/awardCheck";
	}
	//科技奖励修改界面
	@RequestMapping("awardEdit.do")
	public String awardEdit(){
		return "page/science/award/awardEdit";
	}
	//科技奖励资料审查界面
	@RequestMapping("awardProcess.do")
	public ModelAndView awardProcess(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("rewardName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("rewardSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("rewardAwardtime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/award/awardProcess", "utflist", result);
	}
	//科技奖励文件重新上传
	@RequestMapping("awardfilereload.do")
	public ModelAndView awardfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("userID").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("step").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("pat").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/award/awardfilereload", "utflist", result);
	}
	//科技奖励资料审查文件预览界面
	@RequestMapping("awardData.do")
	public ModelAndView awardData(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("rewardName").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("rewardSource").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("rewardAwardtime").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/award/awardData", "utflist", result);
	}
	//科技奖励资料审查文件流程添加界面
	@RequestMapping("awardDataAdd.do")
	public String awardDataAdd(){
		return "page/science/award/awardDataAdd";
	}
	//科技奖励资料审查文件添加界面
	@RequestMapping("awardDataAddFile.do")
	public String awardDataAddFile(){
		return "page/science/award/awardDataAddFile";
	}
		
	//论文
	@RequestMapping("paper.do")
	public String paper(){
		return "page/science/paper/paper";
	}
	//论文添加
	@RequestMapping("paperAdd.do")
	public String paperAdd(){
		return "page/science/paper/paperAdd";
	}
	//论文修改
	@RequestMapping("paperEdit.do")
	public String paperEdit(){
		return "page/science/paper/paperEdit";
	}
	//论文查看详情
	@RequestMapping("paperCheck.do")
	public String paperCheck(){
		return "page/science/paper/paperCheck";
	}
	//论文文件重新上传
	@RequestMapping("paperfilereload.do")
	public ModelAndView paperfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("topic").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("style").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tid").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/paper/paperfilereload", "utflist", result);
	}
	//论文多文件重新上传
	@RequestMapping("paperfilereloadadd.do")
	public ModelAndView paperfilereloadadd(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("topic").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("style").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("address").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/paper/paperfilereloadadd", "utflist", result);
	}
	//会议论文
	@RequestMapping("papermeeting.do")
	public String papermeeting(){
		return "page/science/papermeeting/papermeeting";
	}
	//会议论文添加
	@RequestMapping("papermeetingAdd.do")
	public String papermeetingAddr(){
		return "page/science/papermeeting/papermeetingAdd";
	}
	//会议论文修改
	@RequestMapping("papermeetingEdit.do")
	public String papermeetingEdit(){
		return "page/science/papermeeting/papermeetingEdit";
	}
	//会议论文查看详情
	@RequestMapping("papermeetingCheck.do")
	public String papermeetingCheck(){
		return "page/science/papermeeting/papermeetingCheck";
	}
	//会议论文文件重新上传
	@RequestMapping("papermeetingfilereload.do")
	public ModelAndView papermeetingfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("topic").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("style").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("tid").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/paper/papermeetingfilereload", "utflist", result);
	}
	//会议论文多文件重新上传
	@RequestMapping("papermeetingfilereloadadd.do")
	public ModelAndView papermeetingfilereloadadd(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("topic").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("style").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("address").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/paper/papermeetingfilereloadadd", "utflist", result);
	}
	//著作
	@RequestMapping("work.do")
	public String work(){
		return "page/science/work/work";
	}
	//著作添加
	@RequestMapping("workAdd.do")
	public String workAdd(){
		return "page/science/work/workAdd";
	}
	//著作查看详情
	@RequestMapping("workCheck.do")
	public String workCheck(){
		return "page/science/work/workCheck";
	}
	//著作修改
	@RequestMapping("workEdit.do")
	public String workEdit(){
		return "page/science/work/workEdit";
	}
	//著作文件重新上传
	@RequestMapping("workfilereload.do")
	public ModelAndView workfilereload(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("topic").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("style").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("wid").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/paper/workfilereload", "utflist", result);
	}
	//著作多文件重新上传
	@RequestMapping("workfilereloadadd.do")
	public ModelAndView workfilereloadadd(HttpServletRequest request) throws UnsupportedEncodingException{
		List<String> result=new ArrayList<String>();
		result.add(new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("topic").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("style").getBytes("ISO-8859-1"),"utf-8"));
		result.add(new String(request.getParameter("address").getBytes("ISO-8859-1"),"utf-8"));
		return new ModelAndView("page/science/paper/workfilereloadadd", "utflist", result);
	}
	//消息管理
	@RequestMapping("newsScience.do")
	public String newsScience(){
		return "page/science/newsScience";
	}
}
