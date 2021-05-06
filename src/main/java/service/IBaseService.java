package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IBaseService<G> {
    public ArrayList<String> listResult(G g) throws SQLException;
    public List<G> getAll() throws SQLException;
    public ArrayList<String> insert(G g) throws SQLException;
    public ArrayList<String> update( G g) throws SQLException;
    public boolean delete(int id) throws SQLException;
    public G findById(int id) throws SQLException;
    public boolean checkDuplicate(G g) throws SQLException;
}
