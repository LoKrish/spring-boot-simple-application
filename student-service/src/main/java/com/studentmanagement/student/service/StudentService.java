package com.studentmanagement.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.student.data.StudentData;
import com.studentmanagement.student.model.Student;
import com.studentmanagement.student.model.StudentName;
import com.studentmanagement.student.model.Students;
import com.studentmanagement.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<StudentName> getStudentByGender(String gender) throws JSONException {
		List<String> jsonString = studentRepository.getStudentByGender(gender);
		String json = String.join(",", jsonString);
		json = "[" + json + "]";
		JSONArray jsonArray = new JSONArray(json);
		List<StudentName> studentNames = new ArrayList<StudentName>();

		for (int i = 0; i < jsonArray.length(); i++) {
			StudentName tempStudentName = new StudentName();
			String firstName = jsonArray.getJSONObject(i).getString("firstName");
			String lastName = jsonArray.getJSONObject(i).getString("lastName");
			String name = firstName + " " + lastName;
			tempStudentName.setName(name);
			studentNames.add(tempStudentName);
		}
		return studentNames;
	}

	public List<StudentName> getStudentByStandardAndSection(String standard, String section) throws JSONException {
		List<String> jsonString = studentRepository.getStudentByStandardAndSection(standard, section);
		String json = String.join(",", jsonString);
		json = "[" + json + "]";
		JSONArray jsonArray = new JSONArray(json);
		List<StudentName> studentNames = new ArrayList<StudentName>();

		for (int i = 0; i < jsonArray.length(); i++) {
			StudentName tempStudentName = new StudentName();
			String firstName = jsonArray.getJSONObject(i).getString("firstName");
			String lastName = jsonArray.getJSONObject(i).getString("lastName");
			String name = firstName + " " + lastName;
			tempStudentName.setName(name);
			studentNames.add(tempStudentName);
		}
		return studentNames;
	}

	public List<StudentName> getStudentByRollNumber(int rollNumber) throws JSONException {
		List<String> jsonString = studentRepository.getStudentByRollNumber(rollNumber);
		String json = String.join(",", jsonString);
		json = "[" + json + "]";
		JSONArray jsonArray = new JSONArray(json);
		List<StudentName> studentNames = new ArrayList<StudentName>();

		for (int i = 0; i < jsonArray.length(); i++) {
			StudentName tempStudentName = new StudentName();
			String firstName = jsonArray.getJSONObject(i).getString("firstName");
			String lastName = jsonArray.getJSONObject(i).getString("lastName");
			String name = firstName + " " + lastName;
			tempStudentName.setName(name);
			studentNames.add(tempStudentName);
		}
		return studentNames;
	}

	public Student saveStudent(Student student) {
		studentRepository.save(student);
		return student;
	}

	public String isStudentPresent(String name) throws JSONException {
		List<StudentName> nameList = getFirstName();

		ListIterator<StudentName> iterator = nameList.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getName().equals(name)) {
				return name + " is present";
			}
		}
		return name + " is not present";
	}

	public List<StudentName> getFirstName() throws JSONException {
		List<String> jsonString = studentRepository.getStudentFirstName();
		String json = String.join(",", jsonString);
		json = "[" + json + "]";
		JSONArray jsonArray = new JSONArray(json);
		List<StudentName> studentNames = new ArrayList<StudentName>();

		for (int i = 0; i < jsonArray.length(); i++) {
			StudentName tempStudentName = new StudentName();
			tempStudentName.setName(jsonArray.getJSONObject(i).getString("firstName"));
			studentNames.add(tempStudentName);
		}
		return studentNames;
	}

	public Students getStudents() {
		return new Students();
	}
}
