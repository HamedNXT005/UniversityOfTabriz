package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.Teacher;
import com.example.universityoftabriz.Repository.HistorySalaryRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class HistorySalaryService {
    @Autowired
    private HistorySalaryRepository historySalaryRepository;

    public void updateHistorySalary(HistorySalary historySalary) {
        historySalaryRepository.save(historySalary);
    }

    public List<HistorySalary> getHistorySByUserId(Long userId){
        return historySalaryRepository.findByUserId(userId);
    }

    public List<HistorySalary> getHistorySByYearEdAndSemester(Timestamp yearEd, int semester){
        return historySalaryRepository.findByYearEdAndSemester(yearEd,semester);
    }

    public Optional<HistorySalary> getHistorySByUserIdAndYearEdAndSemester(Long userId, Timestamp yearEd, int semester){
        return historySalaryRepository.findByUserIdAndYearEdAndSemester(userId, yearEd, semester);
    }

    public void exportSalary(HistorySalary report, Teacher teacher, ByteArrayOutputStream outputStream) throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);
        document.open();
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24,BaseColor.BLACK);
        Paragraph title = new Paragraph("Salary Report", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14,BaseColor.DARK_GRAY);
        Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 12,BaseColor.GRAY);
        document.add(new Paragraph("Teacher's Id: " + teacher.getId(), bodyFont));
        document.add(new Paragraph("Name: " + teacher.getNameF()+" "+teacher.getNameL(), bodyFont));
        document.add(new Paragraph("Faculty: " + teacher.getFaculty(), bodyFont));
        document.add(new Paragraph("National code: " + teacher.getNationalCode(), bodyFont));
        document.add(new Paragraph("\n"));
        try {
            Image image = Image.getInstance(teacher.getPhoto());
            image.setAlignment(Element.ALIGN_CENTER);
            document.add(image);
        } catch (IOException | BadElementException ignored) {
        }
        PdfPTable table = new PdfPTable(2);
        float borderWidth = 1f;
        table.setWidthPercentage(100);
        table.setWidths(new float[]{3, 2});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Index", headerFont));
        cell.setBorderWidth(borderWidth);
        cell.setBorderColor(BaseColor.BLACK);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(8);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Measure", headerFont));
        cell.setBorderWidth(borderWidth);
        cell.setBorderColor(BaseColor.BLACK);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(8);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        table.addCell(new Phrase("Educational Year", bodyFont));
        table.addCell(new Phrase(String.valueOf(report.getYearEd()), bodyFont));
        table.addCell(new Phrase("Semester", bodyFont));
        table.addCell(new Phrase(String.valueOf(report.getSemester()), bodyFont));
        table.addCell(new Phrase("Hours Spent Teaching", bodyFont));
        table.addCell(new Phrase(String.valueOf(report.getHoursTaught()), bodyFont));
        table.addCell(new Phrase("Salary", bodyFont));
        table.addCell(new Phrase(String.valueOf(report.getSalary()), bodyFont));
        table.addCell(new Phrase("Payment Date", bodyFont));
        table.addCell(new Phrase(String.valueOf(report.getPayment_date()), bodyFont));
        document.add(table);
        document.close();
    }
}
