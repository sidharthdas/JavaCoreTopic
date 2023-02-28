package mapAllFunctionalities;

/**
 * @author Sidharth Das
 * created on  28/02/23
 */
public class StudentDTD {

    private String studentName;
    private String className;
    private String sectionName;
    private String studentPhn;
    private String studentAdd;
    private String studentAddmisionYear;
    private String studentAddmissionMonth;

    public StudentDTD(String studentName, String className, String sectionName, String studentPhn, String studentAdd, String studentAddmisionYear, String studentAddmissionMonth) {
        this.studentName = studentName;
        this.className = className;
        this.sectionName = sectionName;
        this.studentPhn = studentPhn;
        this.studentAdd = studentAdd;
        this.studentAddmisionYear = studentAddmisionYear;
        this.studentAddmissionMonth = studentAddmissionMonth;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getStudentPhn() {
        return studentPhn;
    }

    public void setStudentPhn(String studentPhn) {
        this.studentPhn = studentPhn;
    }

    public String getStudentAdd() {
        return studentAdd;
    }

    public void setStudentAdd(String studentAdd) {
        this.studentAdd = studentAdd;
    }

    public String getStudentAddmisionYear() {
        return studentAddmisionYear;
    }

    public void setStudentAddmisionYear(String studentAddmisionYear) {
        this.studentAddmisionYear = studentAddmisionYear;
    }

    public String getStudentAddmissionMonth() {
        return studentAddmissionMonth;
    }

    public void setStudentAddmissionMonth(String studentAddmissionMonth) {
        this.studentAddmissionMonth = studentAddmissionMonth;
    }
}
