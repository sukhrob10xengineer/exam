import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//todo - in this class create two methods that can handle file copying
// 1.first method must include src file and from it your method will have to
// create another duplicate file. Then name of duplicate file should be like
// notes.txt => notes(1).txt
// 2.second method must include as an input two parameters , scr file and
// destination file. This method will read from src file and writes to
// destination file.
// 3.For the class involve logger to log method operation details.
// When your methods throw an exception log error message to the console
// When copy file successfully finishes log info about it.
public class Streams {
    private static final Logger logger = Logger.getLogger(Streams.class.getName());

    public void copyFileWithDuplicateName(File srcFile) {
        try {
            String fileName = srcFile.getName();
            String[] nameParts = fileName.split("\\.");
            String baseName = nameParts[0];
            String extension = nameParts[1];

            int copyNumber = 1;
            File destFile = new File(baseName + "(" + copyNumber + ")." + extension);
            while (destFile.exists()) {
                copyNumber++;
                destFile = new File(baseName + "(" + copyNumber + ")." + extension);
            }

            copy(srcFile, destFile);
            logger.info("File copied successfully: " + srcFile.getName() + " -> " + destFile.getName());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error copying file: " + e.getMessage(), e);
        }
    }

    public void copyFile(File srcFile, File destFile) {
        try {
            copy(srcFile, destFile);
            logger.info("File copied successfully: " + srcFile.getName() + " -> " + destFile.getName());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error copying file: " + e.getMessage(), e);
        }
    }

    private void copy(File srcFile, File destFile) throws IOException {
        try (InputStream in = new FileInputStream(srcFile);
             OutputStream out = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

}
