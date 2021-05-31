package ua.itea.repository.impl;

import com.sun.istack.internal.Nullable;
import ua.itea.exception.DataAccessException;
import ua.itea.model.Pudge;
import ua.itea.repository.PudgeRepository;

import java.io.*;

public class PudgeRepositoryImpl implements PudgeRepository {

    private final String fileName;

    public PudgeRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Nullable
    @Override
    public Pudge find() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            String name = dis.readUTF();
            int level = dis.readInt();
            return new Pudge(name, level);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public Pudge save(Pudge pudge) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeUTF(pudge.getName());
            dos.writeInt(pudge.getLevel());
        } catch (IOException e) {
            throw new DataAccessException(e.getMessage());
        }
        return pudge;
    }
}
