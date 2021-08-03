package com.codeclan.example.FilesAndFolders.components;


import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.models.User;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.example.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) {

        User aly = new User("Aly Smith");
        userRepository.save(aly);

        User gary = new User("Gary Darnell");
        userRepository.save(gary);

        User sara = new User("Sara Humphries");
        userRepository.save(sara);


        Folder codeWork = new Folder("CodeClanWork", aly);
        folderRepository.save(codeWork);

        Folder classNotes = new Folder("E49ClassNotes", sara);
        folderRepository.save(classNotes);

        Folder music = new Folder("Music", gary);
        folderRepository.save(music);


        File bookLab = new File("BookLab", "md", 64, classNotes);
        fileRepository.save(bookLab);

        File projectBrief = new File("Education Station", "txt", 128, codeWork);
        fileRepository.save(projectBrief);

        File learnToFly = new File("Learn To Fly", "wav", 4000, music);
        fileRepository.save(learnToFly);

        File thePretender = new File("The Pretender", "mp4", 5000, music);
        fileRepository.save(thePretender);
    }
}
