package org.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.com.model.PageBean;
import org.com.model.Patient;
import org.com.util.DateUtil;
import org.com.util.StringUtil;

public class PatientDao {
	/**
	 * 得到patient查询结果
	 * @param con
	 * @param pageBean
	 * @param patient
	 * @return
	 * @throws Exception
	 */
	public ResultSet patientList(Connection con,PageBean pageBean,Patient patient,String bbirthday,String ebirthday)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_patient p,t_user u where p.userId=u.userId");
		if(patient.getUserId()!=-1){
			sb.append(" and p.userId = '"+patient.getUserId()+"'");
		}
		if(StringUtil.isNotEmpty(patient.getPatientName())){
			sb.append(" and p.patientName like '%"+patient.getPatientName()+"%'");
		}
		if(StringUtil.isNotEmpty(patient.getSex())){
			sb.append(" and p.sex ='"+patient.getSex()+"'");
		}
		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(p.birthday)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(p.birthday)<=TO_DAYS('"+ebirthday+"')");
		}
		//分页
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 获取数据总条数
	 * @param con
	 * @param grade
	 * @return
	 * @throws Exception
	 */
	public int patientCount(Connection con,Patient patient,String bbirthday,String ebirthday)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_patient");
		if(patient.getUserId()!=-1){
			sb.append(" and userId = '"+patient.getUserId()+"'");
		}
		if(StringUtil.isNotEmpty(patient.getPatientName())){
			sb.append(" and patientName like '%"+patient.getPatientName()+"%'");
		}
		if(StringUtil.isNotEmpty(patient.getSex())){
			sb.append(" and sex ='"+patient.getSex()+"'");
		}
		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(birthday)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(birthday)<=TO_DAYS('"+ebirthday+"')");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	/**
	 * 数据库插入数据
	 * @param con
	 * @param patient
	 * @return
	 * @throws Exception
	 */
	public int patientAdd(Connection con,Patient patient)throws Exception{
		String sql="insert into t_patient values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, patient.getUserId());
		pstmt.setString(2, patient.getPatientName());
		pstmt.setString(3, patient.getSex());
		pstmt.setString(4, DateUtil.formatDate(patient.getBirthday(), "yyyy-MM-dd"));
		pstmt.setString(5, patient.getIdNumber());
		pstmt.setString(6, patient.getTel());
		pstmt.setString(7, patient.getPatientDesc());
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * 删除数据
	 * @param con
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int patientDelete(Connection con,String delIds)throws Exception{
		String sql="delete from t_patient where patientId in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	/**
	 * 患者资料更改
	 * @param con
	 * @param patient
	 * @return
	 * @throws Exception
	 */
	public int patientModify(Connection con,Patient patient)throws Exception{
		String sql="update t_patient set userId=?,patientName=?,sex=?,birthday=?,idNumber=?,tel=?,patientDesc=? where patientId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, patient.getUserId());
		pstmt.setString(2, patient.getPatientName());
		pstmt.setString(3, patient.getSex());
		pstmt.setString(4, DateUtil.formatDate(patient.getBirthday(), "yyyy-MM-dd"));
		pstmt.setString(5, patient.getIdNumber());
		pstmt.setString(6, patient.getTel());
		pstmt.setString(7, patient.getPatientDesc());
		pstmt.setInt(8, patient.getPatientId());
		return pstmt.executeUpdate();
	}
}
