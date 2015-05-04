package org.com.action;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.com.dao.PatientDao;
import org.com.dao.UserDao;
import org.com.model.PageBean;
import org.com.model.Patient;
import org.com.model.User;
import org.com.util.DbUtil;
import org.com.util.JsonUtil;
import org.com.util.ResponseUtil;
import org.com.util.StringUtil;

import com.opensymphony.xwork2.ActionSupport;

public class PatientAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Patient patient;// patient对象
	private String page;// 分页数据
	private String rows;// 分页数据
	private String delIds;// 批量删除数据的序列号
	private String patientId;// 修改患者资料传递的患者编号
	// 查询条件的变量
	private String s_patientName;
	private String s_sex;
	private String s_bbirthday;
	private String s_ebirthday;
	private String s_userId;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDelIds() {
		return delIds;
	}

	public void setDelIds(String delIds) {
		this.delIds = delIds;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getS_patientName() {
		return s_patientName;
	}

	public void setS_patientName(String s_patientName) {
		this.s_patientName = s_patientName;
	}

	public String getS_sex() {
		return s_sex;
	}

	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}

	public String getS_bbirthday() {
		return s_bbirthday;
	}

	public void setS_bbirthday(String s_bbirthday) {
		this.s_bbirthday = s_bbirthday;
	}

	public String getS_ebirthday() {
		return s_ebirthday;
	}

	public void setS_ebirthday(String s_ebirthday) {
		this.s_ebirthday = s_ebirthday;
	}

	public String getS_userId() {
		return s_userId;
	}

	public void setS_userId(String s_userId) {
		this.s_userId = s_userId;
	}

	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();
	PatientDao patientDao = new PatientDao();
	HttpServletRequest request;
	// 当前用户
	User currentUser;

	@Override
	public String execute() throws Exception {
		// 获取Session
		HttpSession session = request.getSession();
		// 链接connection
		Connection con = null;
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));// 分页pageBean
		if (patient == null) {
			patient = new Patient();
		}
		// session中获取当前用户的ID 只查询当前用户增加的患者 只有管理员才全部查询
		currentUser = (User) session.getAttribute("currentUser");
		if (currentUser.getRole() != 0) {
			// 非管理员用户赋值，显示所属用户患者，管理员不赋值查询所有结果
			patient.setUserId(currentUser.getUserId());
		}
		// 将查询条件赋值给patient对象
		if (s_patientName != null) {
			patient.setPatientName(s_patientName);
			patient.setSex(s_sex);
			if (StringUtil.isNotEmpty(s_userId)) {
				patient.setUserId(Integer.parseInt(s_userId));
			}
		}
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(patientDao.patientList(con, pageBean, patient, s_bbirthday, s_ebirthday));
			int total = patientDao.patientCount(con, patient, s_bbirthday, s_ebirthday);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 保存患者数据(新增和修改)
	public String save() throws Exception {
		// 判断patientId是否为空
		if (StringUtil.isNotEmpty(patientId)) {
			patient.setPatientId(Integer.parseInt(patientId));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNums = 0;
			JSONObject result = new JSONObject();
			if (StringUtil.isNotEmpty(patientId)) {
				// 不为空，修改患者信息
				saveNums = patientDao.patientModify(con, patient);
			} else {
				// patientId为空，新增患者
				saveNums = patientDao.patientAdd(con, patient);
			}
			if (saveNums > 0) {
				result.put("success", "true");
			} else {
				result.put("success", "true");// 业务逻辑,需要返回success，但返回的是错误message
				result.put("errorMsg", "保存失败");
			}
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 删除数据
	public String delete() throws Exception {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			int delNums = patientDao.patientDelete(con, delIds);
			if (delNums > 0) {
				result.put("success", "true");
				result.put("delNums", delNums);
			} else {
				result.put("errorMsg", "删除失败");
			}
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 下拉框赋值 如果是管理员可以查询所有用户，如果是用户只能显示当前用户
	public String userNameComboList() throws Exception {
		Connection con = null;
		// 获取Session,判断当前用户类型
		HttpSession session = request.getSession();
		currentUser = (User) session.getAttribute("currentUser");
		if (currentUser.getRole() != 0) {
			// 普通用户显示当前用户
			// 除了管理员以外的账号只查询该账号的患者
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("userId", "");
			jsonObject.put("userName", "请选择...");
			jsonArray.add(jsonObject);
			jsonObject.put("userId", currentUser.getUserId());
			jsonObject.put("userName", currentUser.getUserName());
			jsonArray.add(jsonObject);
			ResponseUtil.write(ServletActionContext.getResponse(), jsonArray);
		} else {
			// 管理员用户
			try {
				con = dbUtil.getCon();
				JSONArray jsonArray = new JSONArray();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("userId", "");
				jsonObject.put("userName", "请选择...");
				jsonArray.add(jsonObject);
				jsonArray.addAll(JsonUtil.formatRsToJsonArray(userDao.userList(con)));
				ResponseUtil.write(ServletActionContext.getResponse(), jsonArray);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// 下拉框赋值 如果是管理员可以查询所有用户的患者，如果是用户只能显示当前用户患者
	public String patientNameComboList() throws Exception {
		Connection con = null;
		if (patient == null) {
			patient = new Patient();
		}
		// 获取Session,判断当前用户类型
		HttpSession session = request.getSession();
		currentUser = (User) session.getAttribute("currentUser");

		con = dbUtil.getCon();
		// 无论当前什么用户，都需要在combobox中添加如下的jsonObject
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("patientId", "");
		jsonObject.put("patientName", "请选择...");
		jsonArray.add(jsonObject);
		if (currentUser.getRole() != 0) {
			try {
				// 普通用户显示当前用户
				// 除了管理员以外的账号只查询该账号的患者

				// 设置非管理员用户id给patient
				patient.setUserId(currentUser.getUserId());
				jsonArray.addAll(JsonUtil.formatRsToJsonArray(patientDao.patientList(con, null, patient, null, null)));
				ResponseUtil.write(ServletActionContext.getResponse(), jsonArray);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 管理员用户
			try {
				jsonArray.addAll(JsonUtil.formatRsToJsonArray(patientDao.patientList(con, null, patient, null, null)));
				ResponseUtil.write(ServletActionContext.getResponse(), jsonArray);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// 输出excel表格（xls）
	public void exportPatient() throws Exception {
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("sheet1");

		// 设置excel每列宽度
		sheet.setColumnWidth(0, 4000);
		sheet.setColumnWidth(1, 3500);

		// 创建字体样式
		HSSFFont font = wb.createFont();
		font.setFontName("Verdana");
		font.setBoldweight((short) 100);
		font.setFontHeight((short) 300);
		font.setColor(HSSFColor.BLUE.index);

		// 创建单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		// 设置边框
		style.setBottomBorderColor(HSSFColor.RED.index);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);

		style.setFont(font);// 设置字体
		style.setWrapText(true);// 自动换行

		// 创建Excel的sheet的一行
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 500);// 设定行的高度
		HSSFCell cell = null;
		// 创建一个Excel的单元格
		String[] cellTitle = { "编号", "患者姓名", "性别", "出生日期", "身份证号", "联系电话", "家庭住址", "所属用户" };
		for (int i = 0; i < cellTitle.length; i++) {
			cell = row.createCell(i);
			// 给Excel的单元格设置样式和赋值
			cell.setCellStyle(style);
			cell.setCellValue(cellTitle[i]);
		}
		// 获取Session
		HttpSession session = request.getSession();
		// 链接connection
		Connection con = null;
		if (patient == null) {
			patient = new Patient();
		}
		// session中获取当前用户的ID 只查询当前用户增加的患者 只有管理员才全部查询
		currentUser = (User) session.getAttribute("currentUser");
		if (currentUser.getRole() != 0) {
			// 非管理员用户赋值，显示所属用户患者，管理员不赋值查询所有结果
			patient.setUserId(currentUser.getUserId());
		}
		// 将查询条件赋值给patient对象
		if (s_patientName != null) {
			patient.setPatientName(s_patientName);
			patient.setSex(s_sex);
			if (StringUtil.isNotEmpty(s_userId)) {
				patient.setUserId(Integer.parseInt(s_userId));
			}
		}
		ResultSet rs = null;
		try {
			con = dbUtil.getCon();
			rs = patientDao.patientList(con, null, patient, s_bbirthday, s_ebirthday);
			int rowIndex = 1;
			while (rs.next()) {
				row = sheet.createRow(rowIndex++);
				cell = row.createCell(0);
				cell.setCellValue(rs.getInt("patientId"));
				cell = row.createCell(1);
				cell.setCellValue(rs.getString("patientName"));
				cell = row.createCell(2);
				cell.setCellValue(rs.getString("sex"));
				cell = row.createCell(3);
				cell.setCellValue(rs.getString("birthday"));
				cell = row.createCell(4);
				cell.setCellValue(rs.getString("idNumber"));
				cell = row.createCell(5);
				cell.setCellValue(rs.getString("tel"));
				cell = row.createCell(6);
				cell.setCellValue(rs.getString("patientDesc"));
				cell = row.createCell(7);
				cell.setCellValue(rs.getString("userName"));
			}

			String exportFileName = "patient.xls";

			ServletActionContext.getResponse().setHeader("Content-Disposition", "attachment;filename=" + new String((exportFileName).getBytes(), "ISO8859-1"));// 设定输出文件头
			ServletActionContext.getResponse().setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型

			OutputStream out = ServletActionContext.getResponse().getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
