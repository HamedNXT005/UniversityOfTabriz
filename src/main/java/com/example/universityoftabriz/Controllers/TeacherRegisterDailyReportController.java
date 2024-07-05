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

import java.sql.Date;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class TeacherRegisterDailyReportController {
    private static final Logger logger = LoggerFactory.getLogger(TeacherRegisterDailyReportController.class);
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ComputerDefinedCoursesService computerDefinedCoursesService;
    @Autowired
    private ComputerReportService computerReportService;
    @Autowired
    private ChemistryDefinedCoursesService chemistryDefinedCoursesService;
    @Autowired
    private ChemistryReportService chemistryReportService;
    @Autowired
    private ElectricDefinedCoursesService electricDefinedCoursesService;
    @Autowired
    private ElectricReportService electricReportService;
    @Autowired
    private MechanicDefinedCoursesService mechanicDefinedCoursesService;
    @Autowired
    private MechanicReportService mechanicReportService;
    @Autowired
    private CivilDefinedCoursesService civilDefinedCoursesService;
    @Autowired
    private CivilReportService civilReportService;

    @RequestMapping("/TeacherPanel/TeacherRegisterDailyReport")
    public String StudentsList(Model model){
        Optional<Teacher> teacher = teacherService.getTeacherByID(LoginController.uid);
        Teacher teacher1 = teacher.get();

        String ImageUrl = teacher1.getPhoto();
        model.addAttribute("ImageURL" , ImageUrl);
        return "TeacherRegisterDailyReport";
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/getInfo")
    @ResponseBody
    public Optional<Teacher> getTeacherInfo(){
        MDC.put("uid", String.valueOf(LoginController.uid));
        logger.info("Teacher's info with id: {} has been sent to the front-end",LoginController.uid);
        MDC.clear();
        return teacherService.getTeacherByID(LoginController.uid);
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/getClassListComputer")
    @ResponseBody
    public List<ComputerDefinedCourses> getClassListComputer(@RequestParam Teacher teacher){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<ComputerDefinedCourses> list = computerDefinedCoursesService.getDCByTeacherId(teacher.getId());
        Iterator<ComputerDefinedCourses> iterator = list.iterator();
        String today = String.valueOf(LocalDate.now().getDayOfWeek());
        while (iterator.hasNext()){
            ComputerDefinedCourses course = iterator.next();
            if (!(course.getPrimaryDay().equals(today)||course.getSecondaryDay().equals(today)))
                iterator.remove();
        }
        logger.info("Today's classes for the teacher with id: {} has been sent to front-end successfully.",teacher.getId());
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/registerToComputer")
    @ResponseBody
    public void registerToComputer(@RequestParam Teacher teacher,@RequestParam long courseId, @RequestParam boolean as,@RequestParam String absents){
        MDC.put("uid",String.valueOf(LoginController.uid));
        ComputerReport report = new ComputerReport();
        ComputerReport lastReport = computerReportService.findLastRecord();
        report.setId(lastReport.getId()+1);
        report.setTeacherId(teacher.getId());
        report.setCourseId(courseId);
        report.setAttendencyStatus(as);
        report.setAbsents(absents);
        report.setDateOfSubmition(Date.valueOf(LocalDate.now()));
        report.setTimeOfSubmition(Time.valueOf(LocalTime.now()));
        computerReportService.updateComputerReport(report);
        logger.info("Report of the class with id: {} was submitted successfully",courseId);
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/getClassListCivil")
    @ResponseBody
    public List<CivilDefinedCourses> getClassListCivil(@RequestParam Teacher teacher){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<CivilDefinedCourses> list = civilDefinedCoursesService.getDCByTeacherId(teacher.getId());
        Iterator<CivilDefinedCourses> iterator = list.iterator();
        String today = String.valueOf(LocalDate.now().getDayOfWeek());
        while (iterator.hasNext()){
            CivilDefinedCourses course = iterator.next();
            if (!(course.getPrimaryDay().equals(today)||course.getSecondaryDay().equals(today)))
                iterator.remove();
        }
        logger.info("Today's classes for the teacher with id: {} has been sent to front-end successfully.",teacher.getId());
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/registerToCivil")
    @ResponseBody
    public void registerToCivil(@RequestParam Teacher teacher,@RequestParam long courseId, @RequestParam boolean as,@RequestParam String absents){
        MDC.put("uid",String.valueOf(LoginController.uid));
        CivilReport report = new CivilReport();
        CivilReport lastReport = civilReportService.findLastRecord();
        report.setId(lastReport.getId()+1);
        report.setTeacherId(teacher.getId());
        report.setCourseId(courseId);
        report.setAttendencyStatus(as);
        report.setAbsents(absents);
        report.setDateOfSubmition(Date.valueOf(LocalDate.now()));
        report.setTimeOfSubmition(Time.valueOf(LocalTime.now()));
        civilReportService.updateCivilReport(report);
        logger.info("Report of the class with id: {} was submitted successfully",courseId);
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/getClassListChemistry")
    @ResponseBody
    public List<ChemistryDefinedCourses> getClassListChemistry(@RequestParam Teacher teacher){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<ChemistryDefinedCourses> list = chemistryDefinedCoursesService.getDCByTeacherId(teacher.getId());
        Iterator<ChemistryDefinedCourses> iterator = list.iterator();
        String today = String.valueOf(LocalDate.now().getDayOfWeek());
        while (iterator.hasNext()){
            ChemistryDefinedCourses course = iterator.next();
            if (!(course.getPrimaryDay().equals(today)||course.getSecondaryDay().equals(today)))
                iterator.remove();
        }
        logger.info("Today's classes for the teacher with id: {} has been sent to front-end successfully.",teacher.getId());
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/registerToChemistry")
    @ResponseBody
    public void registerToChemistry(@RequestParam Teacher teacher,@RequestParam long courseId, @RequestParam boolean as,@RequestParam String absents){
        MDC.put("uid",String.valueOf(LoginController.uid));
        ChemistryReport report = new ChemistryReport();
        ChemistryReport lastReport = chemistryReportService.findLastRecord();
        report.setId(lastReport.getId()+1);
        report.setTeacherId(teacher.getId());
        report.setCourseId(courseId);
        report.setAttendencyStatus(as);
        report.setAbsents(absents);
        report.setDateOfSubmition(Date.valueOf(LocalDate.now()));
        report.setTimeOfSubmition(Time.valueOf(LocalTime.now()));
        chemistryReportService.updateChemistryReport(report);
        logger.info("Report of the class with id: {} was submitted successfully",courseId);
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/getClassListElectric")
    @ResponseBody
    public List<ElectricDefinedCourses> getClassListElectric(@RequestParam Teacher teacher){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<ElectricDefinedCourses> list = electricDefinedCoursesService.getDCByTeacherId(teacher.getId());
        Iterator<ElectricDefinedCourses> iterator = list.iterator();
        String today = String.valueOf(LocalDate.now().getDayOfWeek());
        while (iterator.hasNext()){
            ElectricDefinedCourses course = iterator.next();
            if (!(course.getPrimaryDay().equals(today)||course.getSecondaryDay().equals(today)))
                iterator.remove();
        }
        logger.info("Today's classes for the teacher with id: {} has been sent to front-end successfully.",teacher.getId());
        MDC.clear();
        return list;
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/registerToElectric")
    @ResponseBody
    public void registerToElectric(@RequestParam Teacher teacher,@RequestParam long courseId, @RequestParam boolean as,@RequestParam String absents){
        MDC.put("uid",String.valueOf(LoginController.uid));
        ElectricReport report = new ElectricReport();
        ElectricReport lastReport = electricReportService.findLastRecord();
        report.setId(lastReport.getId()+1);
        report.setTeacherId(teacher.getId());
        report.setCourseId(courseId);
        report.setAttendencyStatus(as);
        report.setAbsents(absents);
        report.setDateOfSubmition(Date.valueOf(LocalDate.now()));
        report.setTimeOfSubmition(Time.valueOf(LocalTime.now()));
        electricReportService.updateElectricReport(report);
        logger.info("Report of the class with id: {} was submitted successfully",courseId);
        MDC.clear();
    }

    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/getClassListMechanic")
    @ResponseBody
    public List<MechanicDefinedCourses> getClassListMechanic(@RequestParam Teacher teacher){
        MDC.put("uid",String.valueOf(LoginController.uid));
        List<MechanicDefinedCourses> list = mechanicDefinedCoursesService.getDCByTeacherId(teacher.getId());
        Iterator<MechanicDefinedCourses> iterator = list.iterator();
        String today = String.valueOf(LocalDate.now().getDayOfWeek());
        while (iterator.hasNext()){
            MechanicDefinedCourses course = iterator.next();
            if (!(course.getPrimaryDay().equals(today)||course.getSecondaryDay().equals(today)))
                iterator.remove();
        }
        logger.info("Today's classes for the teacher with id: {} has been sent to front-end successfully.",teacher.getId());
        MDC.clear();
        return list;
    }
    @GetMapping("/TeacherPanel/TeacherRegisterDailyReport/registerToMechanic")
    @ResponseBody
    public void registerToMechanic(@RequestParam Teacher teacher,@RequestParam long courseId, @RequestParam boolean as,@RequestParam String absents){
        MDC.put("uid",String.valueOf(LoginController.uid));
        MechanicReport report = new MechanicReport();
        MechanicReport lastReport = mechanicReportService.findLastRecord();
        report.setId(lastReport.getId()+1);
        report.setTeacherId(teacher.getId());
        report.setCourseId(courseId);
        report.setAttendencyStatus(as);
        report.setAbsents(absents);
        report.setDateOfSubmition(Date.valueOf(LocalDate.now()));
        report.setTimeOfSubmition(Time.valueOf(LocalTime.now()));
        mechanicReportService.updateMechanicReport(report);
        logger.info("Report of the class with id: {} was submitted successfully",courseId);
        MDC.clear();
    }


}
