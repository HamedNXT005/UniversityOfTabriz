package com.example.universityoftabriz.Controllers;

import com.example.universityoftabriz.Objects.*;
import com.example.universityoftabriz.Services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class TeacherChooseCoursesController {
    private static final Logger logger = LoggerFactory.getLogger(TeacherChooseCoursesController.class);
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ComputerPreCoursesPlanService computerPreCoursesPlanService;
    @Autowired
    private ComputerDefinedCoursesService computerDefinedCoursesService;
    @Autowired
    private ChemistryPreCoursesPlanService chemistryPreCoursesPlanService;
    @Autowired
    private ChemistryDefinedCoursesService chemistryDefinedCoursesService;
    @Autowired
    private CivilPreCoursesPlanService civilPreCoursesPlanService;
    @Autowired
    private CivilDefinedCoursesService civilDefinedCoursesService;
    @Autowired
    private ElectricPreCoursesPlanService electricPreCoursesPlanService;
    @Autowired
    private ElectricDefinedCoursesService electricDefinedCoursesService;
    @Autowired
    private MechanicPreCoursesPlanService mechanicPreCoursesPlanService;
    @Autowired
    private MechanicDefinedCoursesService mechanicDefinedCoursesService;

    @RequestMapping("/TeacherPanel/TeacherChooseCourses")
    public String StudentsList(Model model){
        Optional<Teacher> teacher = teacherService.getTeacherByID(LoginController.uid);
        Teacher teacher1 = teacher.get();

        String ImageUrl = teacher1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "TeacherChooseCourses";
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/getInfo")
    @ResponseBody
    public Optional<Teacher> getTeacherInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return teacherService.getTeacherByID(LoginController.uid);
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/getPreCoursesComputer")
    @ResponseBody
    public List<ComputerPreCoursesPlan> getPreCoursesComputer(@RequestParam Teacher teacher){
        return computerPreCoursesPlanService.getPrePlanByTeacherId(teacher.getId());
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/submitToDefinedComputer")
    @ResponseBody
    public void submitToDefinedComputer(@RequestParam Teacher teacher,@RequestParam List<ComputerPreCoursesPlan> list){
        MDC.put("uid",String.valueOf(LoginController.uid));
        Iterator<ComputerPreCoursesPlan> iterator = list.iterator();
        while (iterator.hasNext()){
            ComputerPreCoursesPlan course = iterator.next();
            ComputerDefinedCourses lastCourse = computerDefinedCoursesService.findLastRecord();
            ComputerDefinedCourses dcourse = new ComputerDefinedCourses();
            dcourse.setId(lastCourse.getId()+1);
            dcourse.setTeacherId(teacher.getId());
            dcourse.setCourseId(course.getCourseId());
            dcourse.setClassN(course.getClassN());
            dcourse.setExamDate(course.getExamDate());
            dcourse.setCapacity(40);
            dcourse.setTimeOfPrimaryDay(Time.valueOf("00:00:00"));
            computerDefinedCoursesService.updateComputerDefinedCourses(dcourse);
            iterator.remove();
            logger.info("Course with id: {} moved successfully to the defined courses table.",dcourse.getCourseId());
        }
        logger.info("All courses were moved successfully to the defined courses table.");
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/getPreCoursesChemistry")
    @ResponseBody
    public List<ChemistryPreCoursesPlan> getPreCoursesChemistry(@RequestParam Teacher teacher){
        return chemistryPreCoursesPlanService.getPrePlanByTeacherId(teacher.getId());
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/submitToDefinedChemistry")
    @ResponseBody
    public void submitToDefinedChemistry(@RequestParam Teacher teacher,@RequestParam List<ChemistryPreCoursesPlan> list){
        MDC.put("uid",String.valueOf(LoginController.uid));
        Iterator<ChemistryPreCoursesPlan> iterator = list.iterator();
        while (iterator.hasNext()){
            ChemistryPreCoursesPlan course = iterator.next();
            ChemistryDefinedCourses lastCourse = chemistryDefinedCoursesService.findLastRecord();
            ChemistryDefinedCourses dcourse = new ChemistryDefinedCourses();
            dcourse.setId(lastCourse.getId()+1);
            dcourse.setTeacherId(teacher.getId());
            dcourse.setCourseId(course.getCourseId());
            dcourse.setClassN(course.getClassN());
            dcourse.setExamDate(course.getExamDate());
            dcourse.setCapacity(40);
            dcourse.setTimeOfPrimaryDay(Time.valueOf("00:00:00"));
            chemistryDefinedCoursesService.updateChemistryDefinedCourses(dcourse);
            iterator.remove();
            logger.info("Course with id: {} moved successfully to the defined courses table.",dcourse.getCourseId());
        }
        logger.info("All courses were moved successfully to the defined courses table.");
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/getPreCoursesCivil")
    @ResponseBody
    public List<CivilPreCoursesPlan> getPreCoursesCivil(@RequestParam Teacher teacher){
        return civilPreCoursesPlanService.getPrePlanByTeacherId(teacher.getId());
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/submitToDefinedCivil")
    @ResponseBody
    public void submitToDefinedCivil(@RequestParam Teacher teacher,@RequestParam List<CivilPreCoursesPlan> list){
        MDC.put("uid",String.valueOf(LoginController.uid));
        Iterator<CivilPreCoursesPlan> iterator = list.iterator();
        while (iterator.hasNext()){
            CivilPreCoursesPlan course = iterator.next();
            CivilDefinedCourses lastCourse = civilDefinedCoursesService.findLastRecord();
            CivilDefinedCourses dcourse = new CivilDefinedCourses();
            dcourse.setId(lastCourse.getId()+1);
            dcourse.setTeacherId(teacher.getId());
            dcourse.setCourseId(course.getCourseId());
            dcourse.setClassN(course.getClassN());
            dcourse.setExamDate(course.getExamDate());
            dcourse.setCapacity(40);
            dcourse.setTimeOfPrimaryDay(Time.valueOf("00:00:00"));
            civilDefinedCoursesService.updateCivilDefinedCourses(dcourse);
            iterator.remove();
            logger.info("Course with id: {} moved successfully to the defined courses table.",dcourse.getCourseId());
        }
        logger.info("All courses were moved successfully to the defined courses table.");
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/getPreCoursesElectric")
    @ResponseBody
    public List<ElectricPreCoursesPlan> getPreCoursesElectric(@RequestParam Teacher teacher){
        return electricPreCoursesPlanService.getPrePlanByTeacherId(teacher.getId());
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/submitToDefinedElectric")
    @ResponseBody
    public void submitToDefinedElectric(@RequestParam Teacher teacher,@RequestParam List<ElectricPreCoursesPlan> list){
        MDC.put("uid",String.valueOf(LoginController.uid));
        Iterator<ElectricPreCoursesPlan> iterator = list.iterator();
        while (iterator.hasNext()){
            ElectricPreCoursesPlan course = iterator.next();
            ElectricDefinedCourses lastCourse = electricDefinedCoursesService.findLastRecord();
            ElectricDefinedCourses dcourse = new ElectricDefinedCourses();
            dcourse.setId(lastCourse.getId()+1);
            dcourse.setTeacherId(teacher.getId());
            dcourse.setCourseId(course.getCourseId());
            dcourse.setClassN(course.getClassN());
            dcourse.setExamDate(course.getExamDate());
            dcourse.setCapacity(40);
            dcourse.setTimeOfPrimaryDay(Time.valueOf("00:00:00"));
            electricDefinedCoursesService.updateElectricDefinedCourses(dcourse);
            iterator.remove();
            logger.info("Course with id: {} moved successfully to the defined courses table.",dcourse.getCourseId());
        }
        logger.info("All courses were moved successfully to the defined courses table.");
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/getPreCoursesMechanic")
    @ResponseBody
    public List<MechanicPreCoursesPlan> getPreCoursesMechanic(@RequestParam Teacher teacher){
        return mechanicPreCoursesPlanService.getPrePlanByTeacherId(teacher.getId());
    }

    @GetMapping("/TeacherPanel/TeacherChooseCourses/submitToDefinedMechanic")
    @ResponseBody
    public void submitToDefinedMechanic(@RequestParam Teacher teacher,@RequestParam List<MechanicPreCoursesPlan> list){
        MDC.put("uid",String.valueOf(LoginController.uid));
        Iterator<MechanicPreCoursesPlan> iterator = list.iterator();
        while (iterator.hasNext()){
            MechanicPreCoursesPlan course = iterator.next();
            MechanicDefinedCourses lastCourse = mechanicDefinedCoursesService.findLastRecord();
            MechanicDefinedCourses dcourse = new MechanicDefinedCourses();
            dcourse.setId(lastCourse.getId()+1);
            dcourse.setTeacherId(teacher.getId());
            dcourse.setCourseId(course.getCourseId());
            dcourse.setClassN(course.getClassN());
            dcourse.setExamDate(course.getExamDate());
            dcourse.setCapacity(40);
            dcourse.setTimeOfPrimaryDay(Time.valueOf("00:00:00"));
            mechanicDefinedCoursesService.updateMechanicDefinedCourses(dcourse);
            iterator.remove();
            logger.info("Course with id: {} moved successfully to the defined courses table.",dcourse.getCourseId());
        }
        logger.info("All courses were moved successfully to the defined courses table.");
        MDC.clear();
    }



}
