package com.fces.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.fces.dao.StudentDao;
import com.fces.domain.Student;
import com.fces.domain.dto.ScoreStudent;
import com.fces.domain.dto.ScoreTeacher;
import com.fces.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Student login(String studentNum, String password) {
		Student student = studentDao.selectStudentByStudentNum(studentNum);
		if (student != null && StringUtils.equals(student.getPassword(), password)) {
			return student;
		}
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		return studentDao.selectAllStudent();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student) > 0 ? student : null;
	}

	@Override
	public Student createStudent(Student student) {
		return studentDao.insertStudent(student) > 0 ? student : null;
	}

	@Override
	public void deleteStudent(String id) {
		studentDao.deleteStudentById(id);
	}

	@Override
	public Student getStudentById(String id) {
		return studentDao.selectStudentById(id);
	}

	@Override
	public List<Student> batchImport(MultipartFile excelFile) {
		Workbook workbook = null;
		try {
			workbook = new HSSFWorkbook(excelFile.getInputStream());
		} catch (OfficeXmlFileException e) {
			try {
				workbook = new XSSFWorkbook(excelFile.getInputStream());
			} catch (Exception ex) {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheetAt(0);
		Row rowHead = sheet.getRow(0);
		System.out.println(rowHead.getPhysicalNumberOfCells());
		if (rowHead.getPhysicalNumberOfCells() != 2) {
			System.out.println("表头数量不正确！");
			return null;
		}
		System.out.println("表头正确");
		int totalRowNum = sheet.getLastRowNum();
        System.out.println("总行数" + totalRowNum);
		Student student;
		List<Student> students = new ArrayList<>();
		for (int i = 1; i <= totalRowNum; i++) {
            System.out.println("for " + i);
			Row row = sheet.getRow(i);
			student = new Student();
			Cell chapterCell = row.getCell(0);
			chapterCell.setCellType(CellType.STRING);
			student.setStudentNum(chapterCell.getStringCellValue());
			Cell sectionCell = row.getCell(1);
			sectionCell.setCellType(CellType.STRING);
			student.setRealName(sectionCell.getStringCellValue());
			student.setPassword("123456");
			students.add(student);
			System.out.println(student);
		}
		return students;
	}

    @Override
    public List<ScoreTeacher> getStudentsByClazzId(String clazzId) {
        return studentDao.selectStudentsByClazzId(clazzId);
    }

	@Override
	public void removeStudentFromClazz(String studentId, String clazzId) {
		studentDao.deleteStudentFromClazz(studentId, clazzId);
	}

	@Override
	public Student isStudentInClazz(String studentId, String clazzId) {
		return studentDao.selectStudentFromClazz(studentId, clazzId);
	}

	@Override
	public void addStudentToClazz(String studentId, String clazzId) {
		studentDao.insertStudentToClazz(studentId, clazzId);
	}

	@Override
	public ScoreTeacher getTeacherScore(String teacherId, String studentId, String clazzId) {
		return studentDao.selectTeacherScore(teacherId, studentId, clazzId);
	}

	@Override
	public int addTeacherScore(String teacherId, String studentId, String clazzId, String score) {
		return studentDao.insertTeacherScore(teacherId, studentId, clazzId, score);
	}

	@Override
	public List<ScoreStudent> getStudentsByClazzId2(String clazzId) {
		return studentDao.selectStudentsByClazzId2(clazzId);
	}

	@Override
	public List<ScoreStudent> getScoredStudentsByClazzId(String fromStudentId, String clazzId) {
		return studentDao.selectBeScoredStudentsByClazzIdAndFromStudentId(clazzId, fromStudentId);
	}

	@Override
	public ScoreStudent getStudentScore(String fromStudentId, String toStudentId, String clazzId) {
		return studentDao.selectStudentScore(fromStudentId, toStudentId, clazzId);
	}

	@Override
	public int addStudentScore(String fromStudentId, String toStudentId, String clazzId, String score) {
		return studentDao.insertStudentScore(fromStudentId, toStudentId, clazzId, score);
	}

	@Override
	public List<ScoreStudent> getToStudentScore(String toStudentId, String clazzId) {
		return studentDao.selectToStudentScore(toStudentId, clazzId);
	}

}
