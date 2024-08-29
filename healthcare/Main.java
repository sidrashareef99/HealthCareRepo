//package healthcare;
//
//import healthcare.model.*;
//import healthcare.service.*;
//import healthcare.repository.*;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        SessionFactory sessionFactory = new Configuration().configure("patient.cfg.xml").buildSessionFactory();
//
//        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl(sessionFactory);
//        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
//        AppointmentRepositoryImpl appointmentRepository = new AppointmentRepositoryImpl(sessionFactory);
//
//        PatientService patientService = new PatientService(patientRepository);
//        DoctorService doctorService = new DoctorService(doctorRepository);
//        AppointmentService appointmentService = new AppointmentService(appointmentRepository);
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.println("Select from the following menu options: ");
//        System.out.println("1. Manage Patients \n 2. Manage Doctors \n 3. Manage Appointments");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//        try {
//            switch (choice) {
//                case 1:
//                    managePatients(sessionFactory,scanner);
//                    break;
//                case 2:
//                    manageDoctors(sessionFactory,scanner);
//                    break;
//                case 3:
//                    manageAppointments(sessionFactory,scanner);
//                    break;
//            }
//        } finally {
//            scanner.close();
//        }
//
//
//    }
//    public static void managePatients(PatientService patientService, Scanner scanner){
//
//        System.out.println("1. Create Patient");
//        System.out.println("2. Read Patient");
//        System.out.println("3. Update Patient");
//        System.out.println("4. Delete Patient");
//
//        Scanner scan = new Scanner(System.in);
//        int choice1 = scanner.nextInt();
//        scanner.nextLine();
//
//        try {
//            switch (choice1) {
//                case 1:
//                    // Application calls the service layer, not the repository directly
//                    Patient newPatient = new Patient();
//                    System.out.print("Enter first name: ");
//                    newPatient.setFirstName(scanner.nextLine());
//                    System.out.print("Enter last name: ");
//                    newPatient.setLastName(scanner.nextLine());
//                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
//                    newPatient.setDateOfBirth(scanner.nextLine());
//                    System.out.print("Enter email: ");
//                    newPatient.setEmail(scanner.nextLine());
//                    System.out.print("Enter phone number: ");
//                    newPatient.setPhoneNumber(scanner.nextLine());
//                    patientService.createPatient(newPatient);  // Use service here
//                    System.out.println("Patient created successfully.");
//                    break;
//                case 2:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Patient ID: ");
//                    int patientId = scanner.nextInt();
//                    Patient patient = patientService.getPatientById(patientId);  // Use service here
//                    if (patient != null) {
//                        System.out.println("Patient ID: " + patient.getPatientId());
//                        System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
//                        System.out.println("Date of Birth: " + patient.getDateOfBirth());
//                        System.out.println("Email: " + patient.getEmail());
//                        System.out.println("Phone: " + patient.getPhoneNumber());
//                    } else {
//                        System.out.println("Patient not found.");
//                    }
//                    break;
//                case 3:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Patient ID: ");
//                    patientId = scanner.nextInt();
//                    scanner.nextLine();  // consume newline
//                    patient = patientService.getPatientById(patientId);  // Use service here
//                    if (patient != null) {
//                        System.out.print("Enter new first name: ");
//                        patient.setFirstName(scanner.nextLine());
//                        System.out.print("Enter new last name: ");
//                        patient.setLastName(scanner.nextLine());
//                        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
//                        patient.setDateOfBirth(scanner.nextLine());
//                        System.out.print("Enter new email: ");
//                        patient.setEmail(scanner.nextLine());
//                        System.out.print("Enter new phone number: ");
//                        patient.setPhoneNumber(scanner.nextLine());
//                        patientService.updatePatient(patient);  // Use service here
//                        System.out.println("Patient updated successfully.");
//                    } else {
//                        System.out.println("Patient not found.");
//                    }
//                    break;
//                case 4:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Patient ID: ");
//                    patientId = scanner.nextInt();
//                    patientService.deletePatient(patientId);  // Use service here
//                    System.out.println("Patient deleted successfully.");
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
//
//
//    public static void manageDoctors(SessionFactory sessionFactory, Scanner scanner){
//
//
//        System.out.println("1. Create Doctor");
//        System.out.println("2. Read Doctor");
//        System.out.println("3. Update Doctor");
//        System.out.println("4. Delete Doctor");
//
//        Scanner scan = new Scanner(System.in);
//        int choice1 = scanner.nextInt();
//        scanner.nextLine();
//
//        try {
//            switch (choice1) {
//                case 1:
//                    // Application calls the service layer, not the repository directly
//                    Doctor newDoctor = new Doctor();
//                    System.out.print("Enter first name: ");
//                    newDoctor.setFirstName(scanner.nextLine());
//                    System.out.print("Enter last name: ");
//                    newDoctor.setLastName(scanner.nextLine());
//                    System.out.print("Enter specialty: ");
//                    newDoctor.setSpecialty(scanner.nextLine());
//                    System.out.print("Enter email: ");
//                    newDoctor.setEmail(scanner.nextLine());
//                    doctorService.createDoctor(newDoctor);  // Use service here
//                    System.out.println("Doctor created successfully.");
//                    break;
//                case 2:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Doctor ID: ");
//                    int doctorId = scanner.nextInt();
//                    Doctor doctor = doctorService.getDoctorById(doctorId);  // Use service here
//                    if (doctor != null) {
//                        System.out.println("Doctor ID: " + doctor.getId());
//                        System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName());
//                        System.out.println("Specialty: " + doctor.getSpecialty());
//                        System.out.println("Email: " + doctor.getEmail());
//                    } else {
//                        System.out.println("Doctor not found.");
//                    }
//                    break;
//                case 3:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Doctor ID: ");
//                    doctorId = scanner.nextInt();
//                    scanner.nextLine();  // consume newline
//                    doctor = doctorService.getDoctorById(doctorId);  // Use service here
//                    if (doctor != null) {
//                        System.out.print("Enter new first name: ");
//                        doctor.setFirstName(scanner.nextLine());
//                        System.out.print("Enter new last name: ");
//                        doctor.setLastName(scanner.nextLine());
//                        System.out.print("Enter new specialty: ");
//                        doctor.setSpecialty(scanner.nextLine());
//                        System.out.print("Enter new email: ");
//                        doctor.setEmail(scanner.nextLine());
//                        doctorService.updateDoctor(doctor);  // Use service here
//                        System.out.println("Doctor updated successfully.");
//                    } else {
//                        System.out.println("Doctor not found.");
//                    }
//                    break;
//                case 4:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Doctor ID: ");
//                    doctorId = scanner.nextInt();
//                    doctorService.deleteDoctor(doctorId);  // Use service here
//                    System.out.println("Doctor deleted successfully.");
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        } finally {
//            scanner.close();
//            sessionFactory.close();
//        }
//    }
//
//    public static void manageAppointments(SessionFactory sessionFactory, Scanner scanner){
//
//
//        System.out.println("1. Create Appointment");
//        System.out.println("2. Read Appointment");
//        System.out.println("3. Update Appointment");
//        System.out.println("4. Delete Appointment");
//
//        Scanner scan = new Scanner(System.in);
//        int choice1 = scanner.nextInt();
//        scanner.nextLine();
//
//        try {
//            switch (choice1) {
//                case 1:
//                    // Application calls the service layer, not the repository directly
//                    Appointment newAppointment = new Appointment();
//                    System.out.print("Enter Patient ID: ");
//                    newAppointment.setPatientId(scanner.nextInt());
//                    System.out.print("Enter Doctor ID: ");
//                    newAppointment.setDoctorId(scanner.nextInt());
//                    System.out.print("Enter Appointment Date: ");
//                    newAppointment.setAppointmentDate(scanner.nextLine());
//                    System.out.print("Enter Notes: ");
//                    newAppointment.setNote(scanner.nextLine());
//                    appointmentService.createAppointment(newAppointment);
//                    System.out.println("Appointment created successfully.");
//                    break;
//                case 2:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Appointment ID: ");
//                    int appointmentId = scanner.nextInt();
//                    Appointment appointment = appointmentService.getAppointmentById(appointmentId);  // Use service here
//                    if (appointment != null) {
//                        System.out.println("Appointment ID: " + appointment.getAppointmentId());
//                        System.out.println("Patient ID: " + appointment.getPatientId());
//                        System.out.println("Doctor ID: " + appointment.getDoctorId());
//                        System.out.println("Appointment Date: " + appointment.getAppointmentDate());
//                        System.out.println("Notes: " + appointment.getNote());
//                    } else {
//                        System.out.println("Appointment not found.");
//                    }
//                    break;
//                case 3:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Appointment ID: ");
//                    appointmentId = scanner.nextInt();
//                    scanner.nextLine();  // consume newline
//                    appointment = appointmentService.getAppointmentById(appointmentId);  // Use service here
//                    if (appointment != null) {
//                        System.out.print("Enter Patient ID: ");
//                        appointment.setPatientId(scanner.nextInt());
//                        System.out.print("Enter Doctor ID: ");
//                        appointment.setDoctorId(scanner.nextInt());                        System.out.print("Enter new last name: ");
//                        System.out.print("Enter Appointment Date: ");
//                        appointment.setAppointmentDate(scanner.nextLine());
//                        appointmentService.updateAppointment(appointment);  // Use service here
//                        System.out.println("Appointment updated successfully.");
//                    } else {
//                        System.out.println("Appontment not found.");
//                    }
//                    break;
//                case 4:
//                    // Application calls the service layer, not the repository directly
//                    System.out.print("Enter Appointment ID: ");
//                    appointmentId = scanner.nextInt();
//                    appointmentService.deleteAppointment(appointmentId);  // Use service here
//                    System.out.println("Appointment deleted successfully.");
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        } finally {
//            scanner.close();
//            sessionFactory.close();
//        }
//    }
//}
