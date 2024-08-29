package healthcare.model;

import jakarta.persistence.*;

@Entity
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentId")
    private int appointmentId;
    @Column(name = "patientId")
    private int patientId;
    @Column(name = "doctorId")
    private int doctorId;
    @Column(name = "appointmentDate")
    private String appointmentDate;
    @Column(name = "note")
    private String note;

    public int getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
