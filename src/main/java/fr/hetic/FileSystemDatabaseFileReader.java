package fr.hetic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FileSystemDatabaseFileReader {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Reader calculateurDB = (Reader) context.getBean("CalculateurDonnees");
        Reader calculateurFS = (Reader) context.getBean("FileProcessor");
        DataSourceEnum source = DataSourceEnum.valueOf(args[0].toUpperCase());

        switch (source) {
            case DATABASE:
                calculateurDB.read(args[1]);
                break;
            case FILESYSTEM:
                calculateurFS.read(args[1]);
                break;
            default:
                System.out.println("Source de données invalide.");
        }
    }
}
