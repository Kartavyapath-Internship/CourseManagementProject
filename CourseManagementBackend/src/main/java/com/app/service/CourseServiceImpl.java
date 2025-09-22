package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BatchCycleDao;
import com.app.dao.CourseDao;
import com.app.dao.CourseTypeDao;
import com.app.dao.PremisesDao;
import com.app.dao.StaffDao;
import com.app.dto.CourseReqDto;
import com.app.dto.CourseRespDto;
import com.app.entity.BatchCycle;
import com.app.entity.Course;
import com.app.entity.Premises;
import com.app.entity.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private final CourseDao courseDao;
	
	@Autowired
    private final BatchCycleDao batchCycleDao;
	
	@Autowired
    private final CourseTypeDao courseTypeDao;
	
	@Autowired
    private final PremisesDao premisesDao;
	
	@Autowired
	private final StaffDao staffDao;

	
	public CourseServiceImpl(CourseDao courseDao, BatchCycleDao batchCycleDao
    		,CourseTypeDao courseTypeDao,PremisesDao premisesDao,StaffDao staffDao) {
        this.courseDao = courseDao;
        this.batchCycleDao = batchCycleDao;
        this.courseTypeDao = courseTypeDao;
        this.premisesDao = premisesDao;
        this.staffDao = staffDao;
        
    }

	//getall courses
	public List<CourseRespDto> getAllCourses() {
        List<Course> courses = courseDao.findAll();
        List<CourseRespDto> responseList = new ArrayList<>();

        for (Course course : courses) {
        	CourseRespDto dto = convertToDto(course);
            responseList.add(dto);
        }
        return responseList;
    }
	
	//getcourse by id
	public CourseRespDto getCourseById(int id) {
        Course course = courseDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
        return convertToDto(course);
    }

	private CourseRespDto convertToDto(Course course) {
        CourseRespDto dto = new CourseRespDto();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());

        if (course.getCourseType() != null) {
            dto.setCourseTypeName(course.getCourseType().getTitle());
        }

        if (course.getBatchCycle() != null) {
            dto.setBatchCycleTitle(course.getBatchCycle().getName());
            dto.setStartDate(course.getBatchCycle().getStartDate().toLocalDate());
            dto.setEndDate(course.getBatchCycle().getEndDate().toLocalDate());

            // derive status
            BatchCycle bc = course.getBatchCycle();
            if (Boolean.TRUE.equals(bc.getIsActive())) {
                dto.setStatus("Active");
            } else {
                dto.setStatus("Closed");
            }
        }

        if (course.getPremisesList() != null) {
            dto.setPremisesName(
                course.getPremisesList().stream()
                        .map(Premises::getInstituteName)
                        .collect(Collectors.toList())
            );
        }

        
        if (course.getStaff() != null && !course.getStaff().isEmpty()) {
            dto.setStaffName(course.getStaff().get(0).getName()); // single staff
        } else {
            dto.setStaffName("No Coordinator Assigned");
        }


        if (course.getStudents() != null) {
            dto.setStudentCount(course.getStudents().size());
        } else {
            dto.setStudentCount(0);
        }


        return dto;
    }

	
	//add new course
	public CourseRespDto addCourse(CourseReqDto dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setStartDate(dto.getStartDate().atStartOfDay());
        course.setEndDate(dto.getEndDate().atStartOfDay());
        
        course.setBatchCycle(batchCycleDao.findById(dto.getBatchCycleId())
                        .orElseThrow(() -> new RuntimeException("BatchCycle not found with id: " + dto.getBatchCycleId()))
        );
        
        course.setCourseType(courseTypeDao.findById(dto.getCourseTypeId())
                .orElseThrow(() -> new RuntimeException("CourseType not found")));
        

        List<Premises> premises = dto.getPremisesId().stream()
        		.map(id -> premisesDao.findById(id).orElseThrow(() -> new RuntimeException("Premises not found")))
        		.collect(Collectors.toList());
        course.setPremisesList(premises);
        

        Staff staff = staffDao.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        course.setStaff(new ArrayList<>(List.of(staff)));
	
        
        Course saved = courseDao.save(course);

        return convertToDto(saved);

    }
	
	
	//update existing course
	public CourseRespDto updateCourse(int id, CourseReqDto dto) {
        Course course = courseDao.findById(id).orElseThrow();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setStartDate(dto.getStartDate().atStartOfDay());
        course.setEndDate(dto.getEndDate().atStartOfDay());
        course.setBatchCycle(batchCycleDao.findById(dto.getBatchCycleId())
                .orElseThrow(() -> new RuntimeException("BatchCycle not found")));

        course.setCourseType(courseTypeDao.findById(dto.getCourseTypeId())
                .orElseThrow(() -> new RuntimeException("CourseType not found")));

        
        List<Premises> premises = dto.getPremisesId().stream()
        		.map(pId -> premisesDao.findById(pId).orElseThrow(() -> new RuntimeException("Premises not found")))
        		.collect(Collectors.toList());
        course.setPremisesList(premises);
        
        
        Staff staff = staffDao.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        course.setStaff(new ArrayList<>(List.of(staff)));

       
        Course updated = courseDao.save(course);
        
        return convertToDto(updated);

    }
	
	//delete course
	public String deleteCourse(int id) {
		 courseDao.deleteById(id);
		 return "Deleted succeessfully";
	}

}