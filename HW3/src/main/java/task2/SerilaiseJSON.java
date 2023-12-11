package task2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;

public class SerilaiseJSON {

    public static void serilaise(StudentV2 student, String fileName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {File json = new File(fileName);
            objectMapper.writeValue(json, student);
            System.out.println("Объект сериализован.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//            objectOutputStream.writeObject(objectMapper.w);
//            System.out.println("Объект сериализован.");
//        }
//        catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static StudentV2 deserilaise(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        StudentV2 student = objectMapper.readValue(new File(fileName),  objectMapper.getTypeFactory()
                .constructType(StudentV2.class));

        System.out.println("Объект десериализован.");
        return student;

    }

}
