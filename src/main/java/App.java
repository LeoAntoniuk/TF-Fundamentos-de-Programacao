import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class App {
    /*
        Criado esses números inteiros para maior facilidade na manipulação de vetores.
     */
    private static final int MAX_TEACHERS = 10;
    private static final int MAX_COURSES = 3;
    private static final int MAX_SUBJECTS = 39;
    private static final int MAX_STUDENTS = 90;
    private static final int MAX_CLASSES = 10;
    private static final int MAX_ASSESSMENTS = 59;
    private static final int MAX_GRADES = 200;

    private static final int MAX_ID_GENERATE = 200;

    /*
        Vetores dos objetos.
        Todos baseados nos exemplos dados em aula.
     */
    private static Teacher[] teachers = new Teacher[MAX_TEACHERS];
    private static Course[] courses = new Course[MAX_COURSES];
    private static Subject[] subjects = new Subject[MAX_SUBJECTS];
    private static Student[] students = new Student[MAX_STUDENTS];
    private static Class[] classes = new Class[MAX_CLASSES];
    private static Assessment[] assessments = new Assessment[MAX_ASSESSMENTS];
    private static Grade[] grades = new Grade[MAX_GRADES];

    private static int[] idGenerated = new int[MAX_ID_GENERATE];

    /*
        Números inteiros criados para verificações e validações.
     */
    private static int teachersNum = 0, classesNum = 0, studentNum = 0, gradeNum = 0, idNum = 0;

    /*
        Main
     */
    public static void main(String[] args) throws Exception {
        int option;

        //BufferedReader foi indicado pela professora/doutora Aline e pesquisado a utilização no google
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        /*
            Inicializadores criados para melhor organização e menos poluição do main.
         */
        initializeCourses();
        initializeSubjects();
        initializeAssessmentes();

        /*
            Menu principal do software.
         */
        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Página Inicial");
            System.out.println(" ");
            System.out.println("0 - Encerrar o programa");
            System.out.println("1 - Cadastros");
            System.out.println("2 - Alterações");
            System.out.println("3 - Informações");
            System.out.println("4 - Rankings");
            System.out.println("5 - Médias");
            System.out.println("6 - Busca");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                case 1:
                    registers(scanner);
                    break;
                case 2:
                    changes(scanner);
                    break;
                case 3:
                    informations(scanner);
                    break;
                case 4:
                    rankings(scanner);
                    break;
                case 5:
                    averages(scanner);
                    break;
                case 6:
                    search(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);

        scanner.close();
    }

    /*
        Inicializadores de objetos pré-cadastrados, conforme combinado em aula e
        comentado pela professora.
     */
    private static void initializeCourses() {
        courses[0] = new Course(2510, "Engenharia de Software", 8, 12);
        courses[1] = new Course(9310, "Engenharia Mecânica", 10, 12);
        courses[2] = new Course(7110, "Medicina", 10, 15);
    }

    private static void initializeSubjects() {
        subjects[0] = new Subject(1001, "Algoritmos e Lógica de Programação", 60);
        subjects[1] = new Subject(1002, "Programação Orientada a Objetos", 30);
        subjects[2] = new Subject(1003, "Estrutura de Dados", 40);
        subjects[3] = new Subject(1004, "Banco de Dados", 50);
        subjects[4] = new Subject(1005, "Engenharia de Requisitos", 90);
        subjects[5] = new Subject(1006, "Arquitetura de Software", 240);
        subjects[6] = new Subject(1007, "Desenvolvimento Web", 70);
        subjects[7] = new Subject(1008, "Testes de Software", 80);
        subjects[8] = new Subject(1009, "Gerência de Projetos", 120);
        subjects[9] = new Subject(1010, "Computação em Nuvem", 60);
        subjects[10] = new Subject(1011, "Segurança da Informação", 90);
        subjects[11] = new Subject(1012, "Inteligência Artificial",30);
        subjects[12] = new Subject(2001, "Cálculo Diferencial e Integral", 120);
        subjects[13] = new Subject(2002, "Física Geral", 80);
        subjects[14] = new Subject(2003, "Desenho Técnico", 40);
        subjects[15] = new Subject(2004, "Mecânica dos Sólidos", 90);
        subjects[16] = new Subject(2005, "Resistência dos Materiais", 80);
        subjects[17] = new Subject(2006, "Termodinâmica", 240);
        subjects[18] = new Subject(2007, "Mecânica dos Fluidos",60);
        subjects[19] = new Subject(2008, "Processos de Fabricação", 80);
        subjects[20] = new Subject(2009, "Elementos de Máquinas", 40);
        subjects[21] = new Subject(2010, "Controle e Automação", 80);
        subjects[22] = new Subject(2011, "Transferência de Calor", 90);
        subjects[23] = new Subject(2012, "Projeto Mecânico", 120);
        subjects[24] = new Subject(3001, "Anatomia Humana", 80);
        subjects[25] = new Subject(3002, "Histologia", 50);
        subjects[26] = new Subject(3003, "Embriologia", 120);
        subjects[27] = new Subject(3004, "Bioquímica", 240);
        subjects[28] = new Subject(3005, "Fisiologia Humana", 360);
        subjects[29] = new Subject(3006, "Patologia Geral", 80);
        subjects[30] = new Subject(3007, "Farmacologia", 160);
        subjects[31] = new Subject(3008, "Microbiologia", 80);
        subjects[32] = new Subject(3009, "Imunologia", 90);
        subjects[33] = new Subject(3010, "Clínica Médica", 90);
        subjects[34] = new Subject(3011, "Cirurgia Geral", 80);
        subjects[35] = new Subject(3012, "Pediatria", 30);
        subjects[36] = new Subject(3013, "Ginecologia e Obstetrícia", 60);
        subjects[37] = new Subject(3014, "Neurologia", 50);
        subjects[38] = new Subject(3015, "Medicina Preventiva", 70);
    }

    private static void initializeAssessmentes() {
        assessments[0] = new Assessment("Prova 1", 0.25, subjects[0], classes);
        assessments[1] = new Assessment("Prova 2", 0.5, subjects[0], classes);
        assessments[2] = new Assessment("Trabalho 1", 0.25, subjects[0], classes);
        assessments[3] = new Assessment("Prova 1", 0.3, subjects[1], classes);
        assessments[4] = new Assessment("Prova 2", 0.3, subjects[1], classes);
        assessments[5] = new Assessment("Trabalho 1", 0.2, subjects[1], classes);
        assessments[6] = new Assessment("Trabalho 2", 0.1, subjects[1], classes);
        assessments[7] = new Assessment("Trabalho 3", 0.1, subjects[1], classes);
        assessments[8] = new Assessment("Prova 1", 0.6, subjects[2], classes);
        assessments[9] = new Assessment("Trabalho 1", 0.3, subjects[2], classes);
        assessments[10] = new Assessment("Trabalho 2", 0.3, subjects[2], classes);
        assessments[11] = new Assessment("Trabalho 1", 0.3, subjects[3], classes);
        assessments[12] = new Assessment("Trabalho 2", 0.3, subjects[3], classes);
        assessments[13] = new Assessment("Trabalho 3", 0.4, subjects[3], classes);
        assessments[14] = new Assessment("Prova 1", 0.5, subjects[4], classes);
        assessments[15] = new Assessment("Prova 2", 0.5, subjects[4], classes);
        assessments[16] = new Assessment("Prova 1", 0.5, subjects[5], classes);
        assessments[17] = new Assessment("Prova 2", 0.5, subjects[5], classes);
        assessments[18] = new Assessment("Prova 1", 0.5, subjects[6], classes);
        assessments[19] = new Assessment("Prova 2", 0.5, subjects[6], classes);
        assessments[20] = new Assessment("Prova 1", 0.5, subjects[7], classes);
        assessments[21] = new Assessment("Prova 2", 0.5, subjects[7], classes);
        assessments[22] = new Assessment("Prova 1", 0.5, subjects[8], classes);
        assessments[23] = new Assessment("Prova 2", 0.5, subjects[8], classes);
        assessments[24] = new Assessment("Prova 1", 0.5, subjects[9], classes);
        assessments[25] = new Assessment("Prova 2", 0.5, subjects[9], classes);
        assessments[26] = new Assessment("Prova 1", 0.5, subjects[10], classes);
        assessments[27] = new Assessment("Prova 2", 0.5, subjects[10], classes);
        assessments[28] = new Assessment("Prova 1", 0.5, subjects[11], classes);
        assessments[29] = new Assessment("Prova 2", 0.5, subjects[11], classes);
        assessments[30] = new Assessment("Prova 1", 0.5, subjects[12], classes);
        assessments[31] = new Assessment("Prova 2", 0.5, subjects[12], classes);
        assessments[32] = new Assessment("Prova 1", 0.5, subjects[13], classes);
        assessments[33] = new Assessment("Prova 2", 0.5, subjects[13], classes);
        assessments[34] = new Assessment("Prova 1", 1.0, subjects[14], classes);
        assessments[35] = new Assessment("Prova 1", 1.0, subjects[15], classes);
        assessments[36] = new Assessment("Prova 1", 1.0, subjects[16], classes);
        assessments[37] = new Assessment("Prova 1", 1.0, subjects[17], classes);
        assessments[38] = new Assessment("Prova 1", 1.0, subjects[18], classes);
        assessments[39] = new Assessment("Prova 1", 1.0, subjects[19], classes);
        assessments[40] = new Assessment("Prova 1", 1.0, subjects[20], classes);
        assessments[41] = new Assessment("Prova 1", 1.0, subjects[21], classes);
        assessments[42] = new Assessment("Prova 1", 1.0, subjects[22], classes);
        assessments[43] = new Assessment("Prova 1", 1.0, subjects[23], classes);
        assessments[44] = new Assessment("Prova 1", 1.0, subjects[24], classes);
        assessments[45] = new Assessment("Prova 1", 1.0, subjects[25], classes);
        assessments[46] = new Assessment("Prova 1", 1.0, subjects[26], classes);
        assessments[47] = new Assessment("Prova 1", 1.0, subjects[27], classes);
        assessments[48] = new Assessment("Prova 1", 1.0, subjects[28], classes);
        assessments[49] = new Assessment("Prova 1", 1.0, subjects[29], classes);
        assessments[50] = new Assessment("Prova 1", 1.0, subjects[30], classes);
        assessments[51] = new Assessment("Prova 1", 1.0, subjects[31], classes);
        assessments[52] = new Assessment("Prova 1", 1.0, subjects[32], classes);
        assessments[53] = new Assessment("Prova 1", 1.0, subjects[33], classes);
        assessments[54] = new Assessment("Prova 1", 1.0, subjects[34], classes);
        assessments[55] = new Assessment("Prova 1", 1.0, subjects[35], classes);
        assessments[56] = new Assessment("Prova 1", 1.0, subjects[36], classes);
        assessments[57] = new Assessment("Prova 1", 1.0, subjects[37], classes);
        assessments[58] = new Assessment("Prova 1", 1.0, subjects[38], classes);
    }

    /*
        Menu de registros, para cadastro de alunos, professores, turmas, notas e adicionar
        um aluno em determinada turma.
     */
    private static void registers(BufferedReader scanner) throws Exception {
        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Cadastros");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Cadastrar professor");
            System.out.println("2 - Cadastrar aluno");
            System.out.println("3 - Cadastrar turma");
            System.out.println("4 - Cadastrar nota");
            System.out.println("5 - Adicionar aluno à turma");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    registerTeacher(scanner);
                    break;
                case 2:
                    registerStudent(scanner);
                    break;
                case 3:
                    registerClass(scanner);
                    break;
                case 4:
                    registerGrade(scanner);
                    break;
                case 5:
                    addStudentToClass(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    /*
        Funcionalidades de cadastros gerais, de professores, alunos, turmas e notas,
        com validações para aqueles que dependem um do outro.
     */
    private static void registerTeacher(BufferedReader scanner) throws Exception {
        if (teachersNum == MAX_TEACHERS) {
            System.out.println("Você atingiu o limite de professores registrados!");
            return;
        }

        if (idNum == MAX_ID_GENERATE) {
            System.out.println("Você atingiu o limite de Identificadores que podem ser criados!");
            return;
        }

        //Classe Random e utilização pesquisada no Google
        int numTeacher = generateId();

        String name, graduation;

        do {
            System.out.print("Digite o nome do professor: ");
            name = scanner.readLine().trim();

            if (name.isEmpty()) {
                System.out.println("O nome não pode ser vazio!");
            }
        } while (name.isEmpty());


        do {
            System.out.print("Digite a graduação do professor: ");
            graduation = scanner.readLine().trim();

            if (graduation.isEmpty()) {
                System.out.println("A graduação não pode ser vazia!");
            }
        } while (graduation.isEmpty());

        teachers[teachersNum] = new Teacher(numTeacher, name, graduation);

        teachersNum++;
    }

    private static void registerClass(BufferedReader scanner) throws Exception {
        if (classesNum == MAX_CLASSES) {
            System.out.println("Você atingiu o limite de turmas registradas!");
            return;
        }

        if (idNum == MAX_ID_GENERATE) {
            System.out.println("Você atingiu o limite de Identificadores que podem ser criados!");
            return;
        }

        int numClass = generateId(), numberClass, option;

        String input;

        do {
            System.out.print("Digite o número da turma (Ex.: 30): ");
            input = scanner.readLine();
            //\d = numeros inteiros e + mais de um numero

            if (!input.matches("\\d+")) {
                System.out.println("Apenas números.");
            }
        } while (!input.matches("\\d+")); //matches estudado via https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/match

        numberClass = Integer.parseInt(input);
        String className = "Turma " + numberClass;

        for (int i = 0; i < classesNum; i++) {
            if (className.equalsIgnoreCase(classes[i].getName())) {
                System.out.println("Essa turma já existe!");
                return;
            }
        }

        if (teachersNum == 0) {
            System.out.println("Você não possui professores registrados!");
            return;
        }

        System.out.println("Escolha um professor para a turma.");

        for (int i = 0; i < teachersNum; i++) {
            System.out.println((i + 1) + " - " + teachers[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > teachersNum) {
                System.out.println("Opção inválida.");
            }
        } while (option > teachersNum);

        Teacher teacher = teachers[option - 1];

        System.out.println("Escolha uma matéria para aderir à turma.");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + " - " + subjects[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > subjects.length) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > subjects.length);

        Subject subject = subjects[option - 1];

        classes[classesNum] = new Class(numClass, className, teacher, subject);

        classesNum++;
    }

    private static void registerStudent(BufferedReader scanner) throws Exception {
        if (studentNum == MAX_STUDENTS) {
            System.out.println("Você atingiu o limite de alunos registrados.");
            return;
        }

        if (idNum == MAX_ID_GENERATE) {
            System.out.println("Você atingiu o limite de Identificadores que podem ser criados!");
            return;
        }

        int numStudent = generateId(), studentAge, option;

        String studentName;

        do {
            System.out.print("Digite o nome do estudante: ");
            studentName = scanner.readLine().trim();

            if (studentName.isEmpty()) {
                System.out.println("O nome não pode ser vazio!");
            }
        } while (studentName.isEmpty());

        do {
            System.out.print("Digite a idade do estudante: ");
            studentAge = Integer.parseInt(scanner.readLine());

            if (studentAge < 1 || studentAge > 120) {
                System.out.println("Idade inválida.");
            }
        } while (studentAge < 1 || studentAge > 120);

        System.out.println("Escolha o curso do estudante.");
        for (int i = 0; i < courses.length; i++) {
            System.out.println((i + 1) + " - " + courses[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > courses.length) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > courses.length);

        Course course = courses[option - 1];

        students[studentNum] = new Student(numStudent, studentName, studentAge, course);

        studentNum++;
    }

    private static void registerGrade(BufferedReader scanner) throws Exception {
        if (gradeNum == MAX_GRADES) {
            System.out.println("Você atingiu o limite de notas digitadas.");
            return;
        }

        if (classesNum == 0) {
            System.out.println("Você não registrou nenhuma turma para adicionar nota!");
            return;
        }

        int option;

        System.out.println("Escolha a turma que deseja cadastrar a nota.");
        System.out.printf("%-10s %-25s %-35s %-6s%n", "Opção", "Turma", "Matéria", "Alunos");

        for (int i = 0; i < classesNum; i++) {
            System.out.printf("%-10d %-25s %-35s %-6d%n", (i + 1), classes[i].getName(), classes[i].getSubject().getName(), classes[i].getStudentsNum());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > classesNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > classesNum);

        Class classSelected = classes[option - 1];

        if (classSelected.getStudentsNum() == 0) {
            System.out.println("Você não adicionou nenhum aluno nessa turma!");
            return;
        }

        System.out.println("Escolha qual aluno você deseja adicionar a nota.");
        System.out.printf("%-10s %-25s%n", "Opção", "Aluno");

        for (int i = 0; i < classSelected.getStudentsNum(); i++) {
            System.out.printf("%-10d %-25s%n", (i + 1), classSelected.getStudents()[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > classSelected.getStudentsNum()) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > classSelected.getStudentsNum());

        Student student = classSelected.getStudents()[option - 1];

        System.out.println("Escolha qual avaliação você deseja cadastrar nota.");
        System.out.printf("%-10s %-25s%n", "Opção", "Avaliação");

        for (int i = 0; i < assessments.length; i++) {
            if (assessments[i].getSubject() == classSelected.getSubject()) {
                System.out.printf("%-10d %-25s%n", (i + 1), assessments[i].getDescription());
            }
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > assessments.length) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > assessments.length);

        Assessment assessment = assessments[option - 1];

        for (int i  = 0; i < gradeNum; i++) {
            if (grades[i].getStudent().getIdentification() == student.getIdentification() && grades[i].getAssessment() == assessment) {
                System.out.println("Esse aluno já possui uma nota cadastrada nessa avaliação!");
                return;
            }
        }

        double value;

        do {
            System.out.print("Qual o valor da nota: ");
            value = Double.parseDouble(scanner.readLine());

            if (value < 0 || value > 10) {
                System.out.println("Valor inválido.");
            }
        } while (value < 0 || value > 10);

        grades[gradeNum] = new Grade(student, assessment, value);

        gradeNum++;
    }

    /*
        Funcionalidade de adicionar um aluno em alguma turma.
     */
    private static void addStudentToClass(BufferedReader scanner) throws Exception{
        if (classesNum == 0) {
            System.out.println("Você não registrou nenhuma turma!");
            return;
        }

        if (studentNum == 0) {
            System.out.println("Você não registrou nenhum estudante!");
            return;
        }

        System.out.println("Escolha qual turma deseja adicionar um aluno.");

        int count = 0, option, seccondCount = 0;

        int[] idx = new int[classesNum];

        for (int i = 0; i < classesNum; i++) {
            if (classes[i].getStudentsNum() < classes[i].getStudents().length) {
                idx[count] = i;
                System.out.println((count + 1) + " - " + classes[i].getName());
                count++;
            }
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > count) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > count);

        Class classSelected = classes[idx[option - 1]];

        Student[] avaibleStudents = new Student[MAX_STUDENTS];

        System.out.println("Escolha qual aluno deseja adicionar à turma:");
        for (int i = 0; i < studentNum; i++) {
            boolean exists = false;
            for (int j = 0; j < classSelected.getStudentsNum(); j++) {
                if (students[i].getIdentification() == classSelected.getStudents()[j].getIdentification()) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                avaibleStudents[seccondCount] = students[i];
                System.out.printf("%-10d - %-35s | %-25s%n", (seccondCount + 1), students[i].getName(), students[i].getCourse().getName());
                seccondCount++;
            }
        }

        do {
            System.out.printf("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > seccondCount) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > seccondCount);

        Student student = avaibleStudents[option - 1];

        if (seccondCount == 0) {
            System.out.println("Todos os alunos já estão cadastrados nessa turma!");
            return;
        }

        classSelected.getStudents()[classSelected.getStudentsNum()] = student;
        classSelected.setStudentsNum(classSelected.getStudentsNum() + 1);
    }

    /*
        Menu para manipulação de dados de professores, alunos, turmas e
        notas já registradas.
     */
    private static void changes(BufferedReader scanner) throws Exception {
        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Alterações");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Alterações do professor");
            System.out.println("2 - Alterações do aluno");
            System.out.println("3 - Alterações das turmas");
            System.out.println("4 - Alterações de notas");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    changesTeacher(scanner);
                    break;
                case 2:
                    changesStudent(scanner);
                    break;
                case 3:
                    changesClass(scanner);
                    break;
                case 4:
                    changesGrade(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    /*
        Menus para cada uma das opções do menu anterior de Alterações, para
        maior opções de alterações.
     */
    private static void changesTeacher(BufferedReader scanner) throws Exception {
        if (teachersNum == 0) {
            System.out.println("Nenhum professor registrado.");
            return;
        }

        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Alterações - Professor");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu de alterações");
            System.out.println("1 - Alterar nome do progessor");
            System.out.println("2 - Alterar graduação do professor");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    changesNameTeacher(scanner);
                    break;
                case 2:
                    changesGraduationTeacher(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private static void changesNameTeacher(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolha um professor:");
        for (int i = 0; i < teachersNum; i++) {
            System.out.printf("%-5d - %-15d %-35s %-25s", (i + 1), teachers[i].getIdentification(), teachers[i].getName(), teachers[i].getGraduation());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > teachersNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > teachersNum);

        Teacher teacher = teachers[option - 1];

        String name;

        do {
            System.out.print("Digite o nome que deseja: ");
            name = scanner.readLine().trim();

            if (name.isEmpty()) {
                System.out.println("O nome não pode ser vazio!");
            }
        } while (name.isEmpty());

        teacher.setName(name);
        System.out.println("Nome do professor alterado com sucesso!");
    }

    private static void changesGraduationTeacher(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolha um professor:");
        for (int i = 0; i < teachersNum; i++) {
            System.out.printf("%-5d - %-15d %-35s %-25s", (i + 1), teachers[i].getIdentification(), teachers[i].getName(), teachers[i].getGraduation());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > teachersNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > teachersNum);

        Teacher teacher = teachers[option - 1];

        String graduation;

        do {
            System.out.print("Digite a graduação que deseja: ");
            graduation = scanner.readLine().trim();

            if (graduation.isEmpty()) {
                System.out.println("A graduação não pode ser vazia!");
            }
        } while (graduation.isEmpty());

        teacher.setGraduation(graduation);
        System.out.println("Graduação do professor alterado com sucesso!");
    }

    private static void changesStudent(BufferedReader scanner) throws Exception {
        if (studentNum == 0) {
            System.out.println("Nenhuma estudante registrado.");
            return;
        }

        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Alterações - Aluno");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Alterar nome do aluno");
            System.out.println("2 - Alterar idade do aluno");
            System.out.println("3 - Alterar curso do aluno");
            System.out.println("4 - Alterar semestre do aluno");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    changesNameStudent(scanner);
                    break;
                case 2:
                    changesAgeStudent(scanner);
                    break;
                case 3:
                    changesCourseStudent(scanner);
                    break;
                case 4:
                    changesSemesterStudent(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private static void changesNameStudent(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolha um aluno:");
        for (int i = 0; i < studentNum; i++) {
            System.out.printf("%-5d - %-15d %-30s %-10s %-35s %-15s%n", (i + 1), students[i].getIdentification(), students[i].getName(), students[i].getAge() + " Anos", students[i].getCourse().getName(), students[i].getSemester() + " Semestres");
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > studentNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > studentNum);

        Student student = students[option - 1];

        String name;

        do {
            System.out.println("Digite o nome que deseja: ");
            name = scanner.readLine().trim();

            if (name.isEmpty()) {
                System.out.println("O nome não pode ser vazio!");
            }
        } while (name.isEmpty());

        student.setName(name);
        System.out.println("Nome do aluno alterado com sucesso!");
    }

    private static void changesAgeStudent(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolha um aluno:");
        for (int i = 0; i < studentNum; i++) {
            System.out.printf("%-5d - %-15d %-30s %-10s %-35s %-15s%n", (i + 1), students[i].getIdentification(), students[i].getName(), students[i].getAge() + " Anos", students[i].getCourse().getName(), students[i].getSemester() + " Semestres");
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > studentNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > studentNum);

        Student student = students[option - 1];

        int age;

        do {
            System.out.print("Digite a idade que deseja: ");
            age = Integer.parseInt(scanner.readLine());

            if (age < 1 || age > 120) {
                System.out.println("Idade inválida.");
            }
        } while (age < 1 || age > 120);

        student.setAge(age);
        System.out.println("Idade do aluno alterada com sucesso!");
    }

    private static void changesCourseStudent(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolha um aluno:");
        for (int i = 0; i < studentNum; i++) {
            System.out.printf("%-5d - %-15d %-30s %-10s %-35s %-15s%n", (i + 1), students[i].getIdentification(), students[i].getName(), students[i].getAge() + " Anos", students[i].getCourse().getName(), students[i].getSemester() + " Semestres");
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > studentNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > studentNum);

        Student student = students[option - 1];

        int[] idx = new int[courses.length];
        int count = 0;

        System.out.println("Escolha o curso:");
        for (int i = 0; i < courses.length; i++) {
            if (student.getCourse().getCode() != courses[i].getCode()) {
                idx[count] = i;
                System.out.printf("%-5d - %-15d %-35s %-15s %-15s%n", (count + 1), courses[i].getCode(), courses[i].getName(), courses[i].getDuration() + " Semestres", courses[i].getTotalSubjects() + " Matérias");
                count++;
            }
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > count) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > count);

        Course selectedCourse = courses[idx[option - 1]];

        student.setCourse(selectedCourse);

        if (student.getSemester() > selectedCourse.getDuration()) {
            student.setSemester(selectedCourse.getDuration());
        }

        System.out.println("Curso do aluno alterado com sucesso!");
    }

    private static void changesSemesterStudent(BufferedReader scanner) throws Exception {
        int option, semester;

        System.out.println("Escolha um aluno:");
        for (int i = 0; i < studentNum; i++) {
            System.out.printf("%-5d - %-15d %-30s %-10s %-35s %-15s%n", (i + 1), students[i].getIdentification(), students[i].getName(), students[i].getAge() + " Anos", students[i].getCourse().getName(), students[i].getSemester() + " Semestres");
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > studentNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > studentNum);

        Student student = students[option - 1];

        do {
            System.out.print("Digite o semestres: ");
            semester = Integer.parseInt(scanner.readLine());

            if (semester < 1 || semester > student.getCourse().getDuration()) {
                System.out.println("Semestre inválido.");
            }
        } while (semester < 1 || semester > student.getCourse().getDuration());

        student.setSemester(semester);
        System.out.println("Semestre do aluno alterado com sucesso!");
    }

    private static void changesClass(BufferedReader scanner) throws Exception {
        if (classesNum == 0) {
            System.out.println("Nenhuma turma registrada!");
            return;
        }

        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Alterações - Turma");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Alterar número da turma");
            System.out.println("2 - Alterar professor da turma");
            System.out.println("3 - Alterar alunos da turma");
            System.out.println("4 - Alterar matéria da turma");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    changesNumberClass(scanner);
                    break;
                case 2:
                    changesTeacherClass(scanner);
                    break;
                case 3:
                    changesStudentClass(scanner);
                    break;
                case 4:
                    changesSubjectClass(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private static void changesNumberClass(BufferedReader scanner) throws Exception {
        int option, num;

        System.out.println("Escolha uma turma: ");
        for (int i = 0; i < classesNum; i++) {
            System.out.println((i + 1) + " - " + classes[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > classesNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > classesNum);

        Class selectedClass = classes[option - 1];

        do {
            System.out.print("Digite o número da turma: ");
            num = Integer.parseInt(scanner.readLine());

            if (num < 1 || num >= 1000) {
                System.out.println("Coloque um número entre 1 e 999.");
            }
        } while (num < 1 || num >= 1000);

        selectedClass.setName("Turma " + num);
        System.out.println("Número da turma alterado com sucesso!");
    }

    private static void changesTeacherClass(BufferedReader scanner) throws Exception {
        if (teachersNum == 0) {
            System.out.println("Nenhum professor registrado.");
            return;
        }

        int option;

        System.out.println("Escolha uma turma:");
        for (int i = 0; i < classesNum; i++) {
            System.out.println((i + 1) + " - " + classes[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > classesNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > classesNum);

        Class selectedClass = classes[option - 1];

        int[] idx = new int[teachersNum];
        int count = 0;

        System.out.println("Escolha um professor:");
        for (int i = 0; i < teachersNum; i++) {
            if (selectedClass.getTeacher().getIdentification() != teachers[i].getIdentification()) {
                idx[count] = i;
                System.out.println((count + 1) + " - " + teachers[i].getName());
                count++;
            }
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > count) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > count);

        Teacher teacher = teachers[idx[option - 1]];

        System.out.println("Professor da turma alterado com sucesso!");
        selectedClass.setTeacher(teacher);
    }

    private static void changesStudentClass(BufferedReader scanner) throws Exception {
        if (studentNum == 0) {
            System.out.println("Nenhum aluno registrado!");
            return;
        }

        int option;

        System.out.println("Escolha uma turma:");
        for (int i = 0; i < classesNum; i++) {
            System.out.println((i + 1) + " - " + classes[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > classesNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > classesNum);

        Class selectedClass = classes[option - 1];

        if (selectedClass.getStudentsNum() == 0) {
            System.out.println("Essa turma não possui nenhum aluno!");
            return;
        }

        int optionStudent;

        System.out.println("Escolha um aluno para alterar:");
        for (int i = 0; i < selectedClass.getStudentsNum(); i++) {
            System.out.printf("%-5d - %-15d %-35s%n", (i + 1), selectedClass.getStudents()[i].getIdentification(), selectedClass.getStudents()[i].getName());
        }

        do {
            System.out.print("Opção: ");
            optionStudent = Integer.parseInt(scanner.readLine());

            if (optionStudent < 1 || optionStudent > selectedClass.getStudentsNum()) {
                System.out.println("Opção inválida.");
            }
        } while (optionStudent < 1 || optionStudent > selectedClass.getStudentsNum());

        int[] idx = new int[studentNum];
        int count = 0;

        System.out.println("Escolha um aluno para colocar no lugar:");
        for (int i = 0; i < studentNum; i++) {
            boolean exists = false;
            for (int j = 0; j < selectedClass.getStudentsNum(); j++) {
                if (students[i].getIdentification() == selectedClass.getStudents()[j].getIdentification()) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                idx[count] = i;
                System.out.printf("%-5d - %-15d %-35s%n", (count + 1), students[i].getIdentification(), students[i].getName());
                count++;
            }
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > count) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > count);

        Student student = students[idx[option - 1]];

        selectedClass.getStudents()[optionStudent - 1] = student;
        System.out.println("Você alterou o aluno com sucesso!");
    }

    private static void changesSubjectClass(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolher a turma:");
        for (int i = 0; i < classesNum; i++) {
            System.out.println((i + 1) + " - " + classes[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > classesNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > classesNum);

        Class selectedClass = classes[option - 1];

        int[] idx = new int[subjects.length];
        int count = 0;

        System.out.println("Escolha a matéria:");
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].getCode() != selectedClass.getSubject().getCode()) {
                idx[count] = i;
                System.out.printf("%-5d - %-10d %-35s %-10s", (count + 1), subjects[i].getCode(), subjects[i].getName(), subjects[i].getWorkload() + " Horas");
                count++;
            }
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > count) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > count);

        Subject subject = subjects[idx[option - 1]];

        selectedClass.setSubject(subject);
        System.out.println("Matéria alterada com sucesso!");
    }

    private static void changesGrade(BufferedReader scanner) throws Exception {
        if (gradeNum == 0) {
            System.out.println("Nenhuma nota foi registrada ainda!");
            return;
        }

        int option;

        System.out.println("Escolha um aluno para alterar as notas: ");
        for (int i = 0; i < studentNum; i++) {
            System.out.printf("%-2d - %-35s %-30s", (i + 1), students[i].getName(), students[i].getCourse().getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > studentNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > studentNum);

        Student student = students[option - 1];

        int[] idx = new int[gradeNum];
        int count = 0;

        System.out.println("Escolha uma nota de " + student.getName() + " para alterar: ");
        for (int i = 0; i < gradeNum; i++) {
            if (grades[i].getStudent().getIdentification() == student.getIdentification()) {
                idx[count] = i;
                System.out.printf("%-2d - %-35s Peso: %-5.2f Nota: %-5.2f", (count + 1), grades[i].getAssessment().getDescription(), (grades[i].getAssessment().getWeight() * 10), grades[i].getValue());
                count++;
            }
        }

        if (count == 0) {
            System.out.println(student.getName() + " não possui nenhuma nota!");
            return;
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > count) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > count);

        Grade grade = grades[idx[option - 1]];

        double value;

        do {
            System.out.print("Digite a nova nota: ");
            value = Double.parseDouble(scanner.readLine());

            if (value < 0 || value > 10) {
                System.out.println("Valor inválido.");
            }
        } while (value < 0 || value > 10);

        System.out.printf("Nota alterada com sucesso para: %.2f", value);
        grade.setValue(value);
    }

    /*
        Menu de informações para selecionar se deseja ver informações de
        alunos, turmas, professores, cursos, matérias, avaliações, médias,
        todas as notas e médias gerais.
     */
    private static void informations(BufferedReader scanner) throws Exception {
        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Informações");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Informações de aluno");
            System.out.println("2 - Informações de turma");
            System.out.println("3 - Informações de professores");
            System.out.println("4 - Informações de cursos");
            System.out.println("5 - Informações de matérias");
            System.out.println("6 - Informações de avaliações");
            System.out.println("7 - Informações de notas");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    informationsStudents(scanner);
                    break;
                case 2:
                    informationsClasses();
                    break;
                case 3:
                    informationsTeacher();
                    break;
                case 4:
                    informationCourses();
                    break;
                case 5:
                    informationSubject();
                    break;
                case 6:
                    informationAssessment();
                    break;
                case 7:
                    informationGrades();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    /*
        Informações listado de todos os professores.
     */
    private static void informationsTeacher() {
        if (teachersNum == 0) {
            System.out.println("Nenhum professor cadastrado!");
            return;
        }

        System.out.println("Informações dos professores:");
        System.out.printf("%-15s %-35s %-20s%n", "Mátricula", "Professor", "Graduação");

        for (int i = 0; i < teachersNum; i++) {
            System.out.printf("%-15d %-25s %-20s%n", teachers[i].getIdentification(), teachers[i].getName(), teachers[i].getGraduation());
        }
    }

    /*
        Menu para escolher se deseja ver as informações de todos os alunos, ou
        escolher um aluno especifico para ver todos os dados detalhadamente.
     */
    private static void informationsStudents(BufferedReader scanner) throws Exception {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Sistema Acadêmico - Informações - Aluno");
        System.out.println(" ");
        System.out.println("1 - Informações gerais de todos alunos");
        System.out.println("2 - Informações detalhadas de alunos");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.printf("Escolha uma opção: ");

        int option = Integer.parseInt(scanner.readLine());

        switch (option) {
            case 1:
                informationsStudentsAll();
                break;
            case 2:
                informationsStudentsSelect(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    /*
        Informações e listagem de todos os alunos existentes.
     */
    private static void informationsStudentsAll() {
        if (studentNum == 0) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }

        System.out.println("Informação dos alunos:");
        System.out.printf("%-15s %-35s %-10s %-25s %-10s%n", "Mátricula", "Aluno", "Idade", "Curso", "Semestre");

        for (int i = 0; i < studentNum; i++) {
            System.out.printf("%-15d %-35s %-10d %-25s %-10d", students[i].getIdentification(), students[i].getName(), students[i].getAge(), students[i].getCourse().getName(), students[i].getSemester());
        }
    }

    /*
        Informações detalhadas do aluno desejado.
     */
    private static void informationsStudentsSelect(BufferedReader scanner) throws Exception {
        if (studentNum == 0) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }

        int option;

        System.out.println("Escolha um aluno:");

        for (int i = 0; i < studentNum; i++) {
            System.out.println((i + 1) + " - " + students[i].getName());
        }

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > studentNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > studentNum);

        Student selected = students[option - 1];

        System.out.println("\nInformações do Aluno");
        System.out.println("Nome: " + selected.getName());
        System.out.println("Idade: " + selected.getAge());
        System.out.println("Curso: " + selected.getCourse().getName());
        System.out.println("Semestre: " + selected.getSemester());
        System.out.println("Faltam " + (selected.getCourse().getDuration() - selected.getSemester()) + " semestres.");

        System.out.println("\nNotas:");

        double sum = 0, totalWeight = 0;

        for (int i = 0; i < gradeNum; i++) {
            if (grades[i].getStudent().getIdentification() == selected.getIdentification()) {
                System.out.println(grades[i].getAssessment().getDescription() + " | Nota: " + grades[i].getValue() + " | Peso: " + grades[i].getAssessment().getWeight());
                sum += grades[i].getValue() * grades[i].getAssessment().getWeight();
                totalWeight += grades[i].getAssessment().getWeight();
            }
        }

        if (totalWeight == 0) {
            System.out.println("Nenhuma nota registrada.");
            return;
        }

        double average = sum/totalWeight;

        System.out.println("Média final: " + average);

        if (average >= 7) {
            System.out.println("Sytuação: APROVADO");
        } else {
            System.out.println("Situação: REPROVADO");
        }
    }

    /*
        Informações de todas as turmas, cursos, matérias e avaliações.
     */
    private static void informationsClasses() {
        if (classesNum == 0) {
            System.out.println("Nenhuma turma cadastrada!");
            return;
        }

        System.out.println("Informações das turmas:");
        System.out.printf("%-15s %-25s %-25s %-10s %-25s%n", "Identificação", "Turma", "Professor", "Alunos", "Matéria");

        for (int i = 0; i < classesNum; i++) {
            System.out.printf("%-15d %-25s %-25s %-10d %-25s%n", classes[i].getNumber(), classes[i].getName(), classes[i].getTeacher().getName(), classes[i].getStudentsNum(), classes[i].getSubject().getName());
        }
    }

    private static void informationCourses() {
        System.out.println("Informações dos cursos:");
        System.out.printf("%-15s %-25s %-15s %-10s%n", "Identificação", "Curso", "Duração", "Matérias");

        for (int i = 0; i < courses.length; i++) {
            System.out.printf("%-15d %-25s %-15s %-10d%n", courses[i].getCode(), courses[i].getName(), courses[i].getDuration() + " Semestres", courses[i].getTotalSubjects());
        }
    }

    private static void informationSubject() {
        System.out.println("Informação das matérias:");
        System.out.printf("%-15s %-25s %-15s%n", "Identificação", "Matéria", "Carga Horária");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-15d %-25s %-15s%n", subjects[i].getCode(), subjects[i].getName(), subjects[i].getWorkload() + " Horas");
        }
    }

    private static void informationAssessment() {
        System.out.println("Informações da avaliação:");
        System.out.printf("%-15s %-5s %-25s %-7s%n", "Avaliação", "Peso", "Matéria", "Turmas");

        for (int i = 0; i < assessments.length; i++) {
            System.out.printf("%-15s %-5.2f %-35s %-7d%n", assessments[i].getDescription(), assessments[i].getWeight(), assessments[i].getSubject().getName(), assessments[i].getAcademicClass().length);
        }
    }

    private static void informationGrades() {
        if (gradeNum == 0) {
            System.out.println("Nenhuma nota cadastrada.");
            return;
        }

        System.out.printf("%-25s %-35s %-20s %-10s%n", "Aluno", "Matéria", "Avaliação", "Nota");

        for (int i = 0; i < gradeNum; i++) {
            Grade grade = grades[i];
            System.out.printf("%-25s %-35s %-20s %-10.2f%n", grade.getStudent().getName(), grade.getAssessment().getSubject().getName(), grade.getAssessment().getDescription(), grade.getValue());
        }
    }

    /*
        Menu de ranking dos melhores alunos, notas, turmas, médias...
     */
    private static void rankings(BufferedReader scanner) throws Exception {
        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Rankings");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Ranking de maiores/menores notas");
            System.out.println("2 - Ranking de médias por aluno");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    rankingGrades(scanner);
                    break;
                case 2:
                    rankingStudents(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private static void rankingGrades(BufferedReader scanner) throws Exception {
        if (gradeNum == 0) {
            System.out.println("Nenhuma nota foi registrada!");
            return;
        }

        int option;

        do {
            System.out.println("Você deseja ordenar como o Ranking?");
            System.out.println("1 - Maiores notas até menores");
            System.out.println("2 - Menores notas até maiores");
            System.out.print("Opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 1 && option != 2);

        Grade[] sorted = new Grade[gradeNum];

        for (int i = 0; i < gradeNum; i++) sorted[i] = grades[i];

        /*
            Adicionado Bubble Sort, estudado em aula e retirado dos slides da professora,
            porém, otimizado para percorrer apenas indices necessários do vetor.
         */
        for (int i = 0; i < gradeNum - 1; i++) {
            for (int j = 0; j < gradeNum - 1 - i; j++) {
                boolean swap = (option == 1) ? sorted[j].getValue() < sorted[j + 1].getValue() : sorted[j].getValue() > sorted[j + 1].getValue();
                if (swap) {
                    Grade tmp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = tmp;
                }
            }
        }

        System.out.printf("%-10s %-25s %-35s %-20s %-6s%n", "Posição", "Aluno", "Matéria", "Avaliação", "Nota");
        for (int i = 0; i < gradeNum; i++) {
            System.out.printf("%-8d - %-25s %-35s %-20s %-6.2f%n", (i + 1), sorted[i].getStudent().getName(), sorted[i].getAssessment().getSubject().getName(), sorted[i].getAssessment().getDescription(), sorted[i].getValue());
        }
    }

    private static void rankingStudents(BufferedReader scanner) throws Exception {
        if (studentNum == 0) {
            System.out.println("Nenhum estudante foi registrado!");
            return;
        }

        int option;

        do {
            System.out.println("Você deseja ordenar como o Ranking de média dos alunos?");
            System.out.println("1 - Maior média para a menor");
            System.out.println("2 - Menor média para a maior");
            System.out.print("Opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 1 && option != 2);

        double[] averages = new double[studentNum];
        for (int i = 0; i < studentNum; i++) {
            double sum = 0, totalWeight = 0;
            for (int j = 0; j < gradeNum; j++) {
                if (grades[j].getStudent().getIdentification() == students[i].getIdentification()) {
                    sum += grades[j].getValue() * grades[j].getAssessment().getWeight();
                    totalWeight += grades[j].getAssessment().getWeight();
                }
            }
            averages[i] = (totalWeight > 0) ? sum / totalWeight : -1;
        }

        int[] idx = new int[studentNum];
        for (int i = 0; i < studentNum; i++) idx[i] = i;

        for (int i = 0; i < studentNum - 1; i++) {
            for (int j = 0; j < studentNum - 1 - i; j++) {
                boolean swap = (option == 1) ? averages[idx[j]] < averages[idx[j + 1]] : averages[idx[j]] > averages[idx[j + 1]];
                if (swap) {
                    int tmp = idx[j];
                    idx[j] = idx[j + 1];
                    idx[j + 1] = tmp;
                }
            }
        }

        System.out.printf("%-10s %-25s %-20s %-8s%n", "Posição", "Aluno", "Curso", "Média");

        for (int i = 0; i < studentNum; i++) {
            Student student = students[idx[i]];
            if (averages[idx[i]] >= 0) {
                System.out.printf("%-8d - %-25s %-20s %-8.2f%n", (i + 1), student.getName(), student.getCourse().getName(), averages[idx[i]]);
            } else {
                System.out.printf("%-8d - %-25s %-20s %-8s%n", (i + 1), student.getName(), student.getCourse().getName(), "Sem notas");
            }
        }
    }

    /*
        Menu de médias de alunos, turma, matérias, cursos e geral.
     */
    private static void averages(BufferedReader scanner) throws Exception {
        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Médias");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Média dos alunos por turma/matéria");
            System.out.println("2 - Média das turmas por matéria");
            System.out.println("3 - Média do curso");
            System.out.println("4 - Média de uma matéria");
            System.out.println("5 - Média geral de tudo");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso!");
                    break;
                case 1:
                    averageClassBySubject();
                    break;
                case 2:
                    averageStudentBySubject(scanner);
                    break;
                case 3:
                    averageCourse(scanner);
                    break;
                case 4:
                    averageSubject(scanner);
                    break;
                case 5:
                    averageGeneral();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }

    private static void averageClassBySubject() {
        if (classesNum == 0) {
            System.out.println("Nenhuma turma registrada!");
            return;
        }

        System.out.printf("%-10s %-35s %-8s%n", "Turma", "Matéria", "Média");

        for (int i = 0; i < classesNum; i++) {
            double sum = 0, totalWeight = 0;
            for (int j = 0; j < gradeNum; j++) {
                if (grades[j].getAssessment().getSubject() == classes[i].getSubject()) {
                    for (int k = 0; k < classes[i].getStudentsNum(); k++) {
                        if (grades[j].getStudent().getIdentification() == classes[i].getStudents()[k].getIdentification()) {
                            sum += grades[j].getValue() * grades[j].getAssessment().getWeight();
                            totalWeight += grades[j].getAssessment().getWeight();
                            break;
                        }
                    }
                }
            }

            String average = (totalWeight > 0) ? String.format("%.2f", sum/totalWeight) : "Sem notas";
            System.out.printf("%-10s %-35s %-8s%n", classes[i].getName(), classes[i].getSubject().getName(), average);
        }
    }

    private static void averageStudentBySubject(BufferedReader scanner) throws Exception {
        if (studentNum == 0) {
            System.out.println("Nenhum aluno registrado!");
            return;
        }

        int option;

        System.out.println("Escolha um aluno:");
        for (int i = 0; i < studentNum; i++) System.out.println((i + 1) + " - " + students[i].getName());

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > studentNum) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > studentNum);

        Student student = students[option - 1];

        System.out.println("Médias de " + student.getName() + " por matéria:");
        System.out.printf("%-35s %-10s %-8s%n", "Matéria", "Turma", "Média");

        for (int i = 0; i < classesNum; i++) {
            boolean inClass = false;
            for (int j = 0; j < classes[i].getStudentsNum(); j++) {
                if (classes[i].getStudents()[j].getIdentification() == student.getIdentification()) {
                    inClass = true;
                    break;
                }
            }
            if (!inClass) continue;

            double sum = 0, totalWeight = 0;
            for (int k = 0; k < gradeNum; k++) {
                if (grades[k].getStudent().getIdentification() == student.getIdentification() && grades[k].getAssessment().getSubject() == classes[i].getSubject()) {
                    sum += grades[k].getValue() * grades[k].getAssessment().getWeight();
                    totalWeight += grades[k].getAssessment().getWeight();
                }
            }

            String average = (totalWeight > 0) ? String.format("%.2f", sum / totalWeight) : "Sem notas";
            System.out.printf("%-35s %-10s %-8s%n", classes[i].getSubject().getName(), classes[i].getName(), average);
        }
    }

    private static void averageCourse(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolha o curso:");
        for (int i = 0; i < courses.length; i++) System.out.println((i + 1) + " - " + courses[i].getName());

        do {
            System.out.print("Opção: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > courses.length) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > courses.length);

        Course course = courses[option - 1];

        double sum = 0, totalWeight = 0;
        for (int i = 0; i < gradeNum; i++) {
            if (grades[i].getStudent().getCourse().getCode() == course.getCode()) {
                sum += grades[i].getValue() * grades[i].getAssessment().getWeight();
                totalWeight += grades[i].getAssessment().getWeight();
            }
        }

        if (totalWeight == 0) {
            System.out.println("Nenhuma nota registrada nesse curso.");
            return;
        }

        System.out.printf("Média geral do curso %s: %.2f", course.getName(), (sum/totalWeight));
    }

    private static void averageSubject(BufferedReader scanner) throws Exception {
        int option;

        System.out.println("Escolha a matéria:");
        for (int i = 0; i < subjects.length; i++) System.out.println((i + 1) + " - " + subjects[i].getName());

        do {
            System.out.print("Opções: ");
            option = Integer.parseInt(scanner.readLine());

            if (option < 1 || option > subjects.length) {
                System.out.println("Opção inválida.");
            }
        } while (option < 1 || option > subjects.length);

        Subject subject = subjects[option - 1];

        double sum = 0, totalWeight = 0;
        for (int i = 0; i < gradeNum; i++) {
            if (grades[i].getAssessment().getSubject() == subject) {
                sum += grades[i].getValue() * grades[i].getAssessment().getWeight();
                totalWeight += grades[i].getAssessment().getWeight();
            }
        }

        if (totalWeight == 0) {
            System.out.println("Nenhuma nota registrada nessa turma!");
            return;
        }

        System.out.printf("Média da matéria %s: %.2f", subject.getName(), (sum/totalWeight));
    }

    private static void averageGeneral() {
        if (gradeNum == 0) {
            System.out.println("Nenhuma nota registrada.");
            return;
        }

        double sum = 0, totalWeight = 0;
        for (int i = 0; i < gradeNum; i++) {
            sum += grades[i].getValue() * grades[i].getAssessment().getWeight();
            totalWeight += grades[i].getAssessment().getWeight();
        }

        System.out.printf("Média geral de todas as notas: %.2f", (sum/totalWeight));
    }

    /*
        Menu para poder buscar alunos, turmass, cursos, matérias e professores.
     */
    private static void search(BufferedReader scanner) throws Exception {
        int option;

        do {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sistema Acadêmico - Busca");
            System.out.println(" ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Buscar professores");
            System.out.println("2 - Buscar aluno");
            System.out.println("3 - Buscar turma");
            System.out.println("4 - Buscar curso");
            System.out.println("5 - Buscar matéria");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.printf("Escolha uma opção: ");

            option = Integer.parseInt(scanner.readLine());

            switch (option) {
                case 0:
                    System.out.println("Você voltou com sucesso.");
                    break;
                case 1:
                    searchTeacher(scanner);
                    break;
                case 2:
                    searchStudent(scanner);
                    break;
                case 3:
                    searchClass(scanner);
                    break;
                case 4:
                    searchCourse(scanner);
                    break;
                case 5:
                    searchSubject(scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }

    private static void searchTeacher(BufferedReader scanner) throws Exception {
        System.out.print("Digite o nome do professor: ");
        String name = scanner.readLine().toLowerCase();

        boolean found = false;
        System.out.printf("%-15s %-35s %-20s%n", "Mátricula", "Nome", "Graduação");
        for (int i = 0; i < teachersNum; i++) {
            if (teachers[i].getName().toLowerCase().contains(name)) {
                System.out.printf("%-15d %-35s %-20s%n", teachers[i].getIdentification(), teachers[i].getName(), teachers[i].getGraduation());
                found = true;
            }
        }

        if (!found) System.out.println("Nenhum professor com esse nome encontrado!");
    }

    private static void searchStudent(BufferedReader scanner) throws Exception {
        System.out.print("Digite o nome do aluno: ");
        String name = scanner.readLine().toLowerCase();

        boolean found = false;
        System.out.printf("%-15s %-35s %-10s %-35s %-10s%n", "Mátricula", "Aluno", "Idade", "Curso", "Semestre");
        for (int i = 0; i < studentNum; i++) {
            if (students[i].getName().toLowerCase().contains(name)) {
                System.out.printf("%-15d %-35s %-10d %-35s %-10d%n", students[i].getIdentification(), students[i].getName(), students[i].getAge(), students[i].getCourse().getName(), students[i].getSemester());
                found = true;
            }
        }

        if (!found) System.out.println("Nenhum aluno com esse nome encontrado!");
    }

    private static void searchClass(BufferedReader scanner) throws Exception {
        System.out.print("Digite o número da turma (Ex.: 30): ");
        String name = "turma " + scanner.readLine().toLowerCase();

        boolean found = false;
        System.out.printf("%-15s %-15s %-35s %-10s %-35s%n", "Identificação", "Turma", "Professor", "Alunos", "Matéria");
        for (int i = 0; i < classesNum; i++) {
            if (classes[i].getName().toLowerCase().contains(name)) {
                System.out.printf("%-15d %-15s %-35s %-10d %-35s%n", classes[i].getNumber(), classes[i].getName(), classes[i].getTeacher().getName(), classes[i].getStudentsNum(), classes[i].getSubject().getName());
                found = true;
            }
        }

        if (!found) System.out.println("Nenhuma turma encontrada!");
    }

    private static void searchCourse(BufferedReader scanner) throws Exception {
        System.out.print("Digite o nome do curso: ");
        String name = scanner.readLine().toLowerCase();

        boolean found = false;
        System.out.printf("%-15s %-30s %-15s %-10s%n", "Identificação", "Curso", "Duração", "Matérias");
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getName().toLowerCase().contains(name)) {
                System.out.printf("%-15d %-30s %-15s %-10d%n", courses[i].getCode(), courses[i].getName(), courses[i].getDuration() + " Semestres", courses[i].getTotalSubjects());
                found = true;
            }
        }

        if (!found) System.out.println("Nenhum curso encontrado!");
    }

    private static void searchSubject(BufferedReader scanner) throws Exception {
        System.out.println("Digite o nome da matéria: ");
        String name = scanner.readLine().toLowerCase();

        boolean found = false;
        System.out.printf("%-15s %-35s %-20s%n", "Identificação", "Matéria", "Carga Horária");
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].getName().toLowerCase().contains(name)) {
                System.out.printf("%-15d %-35s %-20s", subjects[i].getCode(), subjects[i].getName(), subjects[i].getWorkload() + " Horas");
                found = true;
            }
        }

        if (!found) System.out.println("Nenhuma matéria encontrada!");
    }

    /*
        Gerador de ID, criado para facilitar nos registros/cadastros de turmas, alunos e professores.
     */
    private static int generateId() {
        Random random = new Random();
        int id;
        boolean exists;

        do {
            id = random.nextInt(90000000) + 10000000;
            exists = false;

            for (int i = 0; i < idNum; i++) {
                if (idGenerated[i] == id) {
                    exists = true;
                }
            }
        } while (exists == true);

        idGenerated[idNum] = id;
        idNum++;
        return id;
    }
}
