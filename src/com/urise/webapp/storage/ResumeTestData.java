package urise.webapp.storage;

import urise.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = CreateResume();
        printResume(resume);
    }

    static Resume CreateResume() {
        Map<ContactType, String> contacts = new HashMap<>();
        for (ContactType c : ContactType.values()) {
            switch (c.name()) {
                case "TEL":
                    contacts.put(c, "+7(921) 855-0482");
                    break;
                case "SKYPE":
                    contacts.put(c, "grigory.kislin");
                    break;
                case "EMAIL":
                    contacts.put(c, "gkislin@yandex.ru");
                    break;
                case "LINKEDLN":
                    contacts.put(c, "https://www.linkedin.com/in/gkislin");
                    break;
                case "GITHUB":
                    contacts.put(c, "https://github.com/gkislin");
                    break;
                case "STACKOVERFLOW":
                    contacts.put(c, "https://stackoverflow.com/users/548473");
                    break;
                case "HOMEPAGE":
                    contacts.put(c, "http://gkislin.ru/");
            }
        }
        Map<SectionType, AbstractSection> sections = new HashMap<>();
        for (SectionType st : SectionType.values()) {
            if (st.name().equals("PERSONAL") || st.name().equals("OBJECTIVE")) {
                switch (st.name()) {
                    case "OBJECTIVE":
                        sections.put(st, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
                        break;
                    case "PERSONAL":
                        sections.put(st, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
                }
            } else if (st.name().equals("ACHIEVEMENT") || st.name().equals("QUALIFICATIONS")) {
                switch (st.name()) {
                    case "ACHIEVEMENT":
                        List<String> achievement = new ArrayList<>();
                        achievement.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников. ");
                        achievement.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk. ");
                        achievement.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера. ");
                        sections.put(st, new ListSection(achievement));
                        break;
                    case "QUALIFICATIONS":
                        List<String> qualifications = new ArrayList<>();
                        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
                        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce ");
                        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
                        sections.put(st, new ListSection(qualifications));
                }
            } else if (st.name().equals("EXPERIENCE") || st.name().equals("EDUCATION")) {
                switch (st.name()) {
                    case "EXPERIENCE":
                        List<Experience> experience = new ArrayList<>();

                        experience.add(new Experience("Java Online Projects", "http://javaops.ru/", LocalDate.of(2013, 10, 1), LocalDate.of(2025, 01, 30),
                                "Автор проекта", "Ведущий корпоративного и индивидуального обучения Java. Стажировки Java"));
                        experience.add(new Experience("Wrike", "https://www.wrike.com/", LocalDate.of(2014, 10, 1), LocalDate.of(2016, 01, 30),
                                "Senior backend developer", "Develop and design online project management and collaboration platform Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Zendesk, Redis, HiLoad)."));
                        experience.add(new Experience("RIT Center", "http://ritcenter.com", LocalDate.of(2012, 04, 1), LocalDate.of(2014, 10, 30),
                                "Java architect", "Development process setup for ERP system in multi-environments: release policy, versioning, CI (Jenkins), DB migration, system configuration, AAA via SSO."));

                        sections.put(st, new OrganizationSection(experience));
                        break;
                    case "EDUCATION":
                        List<Experience> education = new ArrayList<>();
                        education.add(new Experience("Coursera", "https://www.coursera.org/", LocalDate.of(2013, 03, 1), LocalDate.of(2013, 05, 30),
                                "Functional Programming Principles in Scala' by Martin Odersky", ""));
                        education.add(new Experience("Luxoft", "https://www.luxoft-training.ru/", LocalDate.of(2011, 03, 1), LocalDate.of(2011, 04, 30),
                                "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'", ""));
                        education.add(new Experience("Siemens AG", "http://www.siemens.ru/", LocalDate.of(2005, 01, 1), LocalDate.of(2005, 04, 30),
                                "3 месяца обучения мобильным IN сетям (Берлин)", ""));

                        sections.put(st, new OrganizationSection(education));
                }
            }
        }
        Resume resume = new Resume("Григорий Кислин", contacts, sections);
        return resume;
    }

    static void printResume(Resume resume) {

        System.out.println(resume.getFullName());
        for (ContactType c : ContactType.values()) {
            if (resume.getContact().get(c) != null) {
                System.out.println(c.getTitle() + ": " + resume.getContact().get(c));
            }
        }

        for (SectionType st : SectionType.values()) {
            System.out.println(st.getTitle());

            if (st.name().equals("PERSONAL") || st.name().equals("OBJECTIVE")) {
                TextSection section = (TextSection) resume.getSections().get(st);
                System.out.println(section.getInfo());
            } else if (st.name().equals("ACHIEVEMENT") || st.name().equals("QUALIFICATIONS")) {
                ListSection section = (ListSection) resume.getSections().get(st);

                List<String> listSection = (List<String>) section.getInfo();
                for (String sls : listSection) {
                    System.out.println(sls);
                }

            } else if (st.name().equals("EXPERIENCE") || st.name().equals("EDUCATION")) {
                OrganizationSection section = (OrganizationSection) resume.getSections().get(st);
                List<Experience> listSection = (List<Experience>) section.getInfo();
                for (Experience sls : listSection) {
                    System.out.println(sls.getName() + " (" + sls.getWebsite() + ")");
                    System.out.println(sls.getPeriods());
                }
            }
        }
    }
}