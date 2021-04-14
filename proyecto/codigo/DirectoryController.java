
import java.io.File;

public class DirectoryController {

    private String[] namesFiles;
    private String directoryPath;
    private boolean compress;
    private boolean decompress;

    public DirectoryController(String directoryPath, boolean compress, boolean decompress) {
        this.directoryPath = directoryPath;
        this.compress = compress;
        this.decompress = decompress;
        getNamesOfFiles();
        createCSVObjects();
    }

    public void createCSVObjects() {

        for (String name : this.namesFiles) {
            CSVFile file = new CSVFile(this.directoryPath + name, this.compress, this.decompress, 3);
            file.save();
        }

    }

    public void getNamesOfFiles() {
        File fs = new File(this.directoryPath);
        this.namesFiles = fs.list();

        if (this.namesFiles.length == 0) {
            System.out.println("Directory not found");
        }

    }

}