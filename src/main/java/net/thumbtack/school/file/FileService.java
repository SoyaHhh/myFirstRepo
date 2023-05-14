package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.figures.v3.Ellipse;
import net.thumbtack.school.figures.v3.FilledEllipse;
import net.thumbtack.school.fillstyle.v3.FillStyleException;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;

public class FileService {


    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        FileService.writeByteArrayToBinaryFile(new File(fileName), array);
    }


    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(array);
        }
    }


    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return FileService.readByteArrayFromBinaryFile(new File(fileName));
    }


    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        }
    }


    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        // REVU везде try-with-resource. Для обоих потоков
        byte[] byteArray;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            bos.write(array);
            byteArray = bos.toByteArray();
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(byteArray)) {
            byte[] newArray = new byte[array.length / 2 + array.length % 2];
            for (int i = 0; i < newArray.length; i++) {
                bis.read(newArray, i, 1);
                bis.skip(1);
            }
            return newArray;
        }
    }


    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bufOs = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bufOs.write(array);
        }
    }


    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bufOs = new BufferedOutputStream(new FileOutputStream(file))) {
            bufOs.write(array);
        }
    }


    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }


    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        try (BufferedInputStream bufIs = new BufferedInputStream(new FileInputStream(file))) {
            return bufIs.readAllBytes();
        }
    }


    public static void writeEllipseToBinaryFile(File file, Ellipse ellipse) throws IOException {
        try (DataOutputStream dataOs = new DataOutputStream(new FileOutputStream(file, true))) {
            dataOs.writeInt(ellipse.getCenter().getX());
            dataOs.writeInt(ellipse.getCenter().getY());
            dataOs.writeInt(ellipse.getXAxis());
            dataOs.writeInt(ellipse.getYAxis());
        }
    }

    public static Ellipse readEllipseFromBinaryFile(File file) throws IOException {
        try (DataInputStream dataIs = new DataInputStream(new FileInputStream(file))) {
            return new Ellipse(dataIs.readInt(), dataIs.readInt(), dataIs.readInt(), dataIs.readInt());
        }
    }


    public static void writeFilledEllipseToBinaryFile(File file, FilledEllipse ellipse) throws IOException {
        // REVU true - лишнее. И без него должно работать
        // а вот если такой файл уже есть, то true приведет к дозаписи в него, чтоь тут совсем не нужно
        try (DataOutputStream dataOs = new DataOutputStream(new FileOutputStream(file))) {
            dataOs.writeInt(ellipse.getCenter().getX());
            dataOs.writeInt(ellipse.getCenter().getY());
            dataOs.writeInt(ellipse.getXAxis());
            dataOs.writeInt(ellipse.getYAxis());
            dataOs.writeUTF(ellipse.getFillStyle().toString());
        }
    }


    public static FilledEllipse readFilledEllipseFromBinaryFile(File file) throws IOException, FillStyleException {
        try (DataInputStream dataIs = new DataInputStream(new FileInputStream(file))) {
            return new FilledEllipse(dataIs.readInt(), dataIs.readInt(), dataIs.readInt(), dataIs.readInt(), dataIs.readUTF());
        }
    }


    public static void writeEllipseArrayToBinaryFile(File file, Ellipse[] ellipses) throws IOException {
        try (DataOutputStream dataOs = new DataOutputStream(new FileOutputStream(file, true))) {
            for (Ellipse ellip : ellipses) {
                dataOs.writeInt(ellip.getCenter().getX());
                dataOs.writeInt(ellip.getCenter().getY());
                dataOs.writeInt(ellip.getXAxis());
                dataOs.writeInt(ellip.getYAxis());

            }
        }
    }


    public static Ellipse[] readEllipseArrayFromBinaryFileReverse(File file) throws IOException {
        Ellipse[] array = new Ellipse[(int) (file.length() / 16)];
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            int index = 0;
            for (int count = 16; count <= file.length(); count += 16) {
                raf.seek(file.length() - count);
                array[index] = new Ellipse(raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt());
                index++;
            }
            raf.close();
            return array;
        }
    }


    public static void writeEllipseToTextFileOneLine(File file, Ellipse ellipse) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")) {
            String str = ellipse.getCenter().getX() + " " + ellipse.getCenter().getY() + " " +
                    ellipse.getXAxis() + " " + ellipse.getYAxis();
            osw.write(str);
        }

    }


    public static Ellipse readEllipseFromTextFileOneLine(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String[] strArray = br.readLine().split(" ");
            return new Ellipse(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]),
                    Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3]));
        }
    }


    public static void writeEllipseToTextFileFourLines(File file, Ellipse ellipse) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(ellipse.getCenter().getX() + "");
            bw.newLine();
            bw.write(ellipse.getCenter().getY() + "");
            bw.newLine();
            bw.write(ellipse.getXAxis() + "");
            bw.newLine();
            bw.write(ellipse.getYAxis() + "");
        }

    }


    public static Ellipse readEllipseFromTextFileFourLines(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            return new Ellipse(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()),
                    Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        }

    }


    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFullName() + " " + trainee.getRating());
        }
    }


    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String[] arrayStrings = br.readLine().split(" ");
            return new Trainee(arrayStrings[0], arrayStrings[1], Integer.parseInt(arrayStrings[2]));
        }
    }


    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFirstName());
            bw.newLine();
            bw.write(trainee.getLastName());
            bw.newLine();
            bw.write(trainee.getRating());
        }
    }


    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            // REVU лучше parseInt
            // RE Вылетает NumberFormatException
            return new Trainee(br.readLine(), br.readLine(), br.readLine().charAt(0));
        }
    }


    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
            // REVU лишнее, все равно сейчас будет закрытие потока, а оно включает в себя flush
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee) ois.readObject();
        }
    }


    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }


    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }


    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(trainee, bw);
        }
    }


    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(br, Trainee.class);
        }
    }
}

