package Oct4Th2022;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author Sidharth Das
 * created on  04/05/23
 */
public class JavaLockCheck {

    public static void main(String[] args) throws InterruptedException, IOException {
        File file = new File("test.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        FileLock fileLock = fileChannel.tryLock();

        Thread.sleep(1000); // Wait for 1 second to simulate another process holding the lock
        boolean result = isFileLocked(file);
        fileLock.release();
        randomAccessFile.close();
    }

    public static boolean isFileLocked(File file) {
        try {
            // Open the file with read-write access
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Try to acquire an exclusive lock on the file
            FileLock fileLock = fileChannel.tryLock();

            // If the lock is null, the file is already locked by another process
            if (fileLock == null) {
                return true;
            }

            // Release the lock and close the file
            fileLock.release();
            randomAccessFile.close();

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
