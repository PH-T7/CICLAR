package dao;

import model.Coletor;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColetorDAO {
    public List<Coletor> getTodosColetores() {
        List<Coletor> coletores = new ArrayList<>();
        String sql = "SELECT * FROM Coletores";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Coletor coletor = new Coletor(
                    rs.getInt("coletor_id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("area_atuacao")
                );
                coletores.add(coletor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coletores;
    }

    public boolean adicionarColetor(Coletor coletor) {
        String sql = "INSERT INTO Coletores (coletor_id, nome, telefone, area_atuacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, coletor.getColetorId());
            pstmt.setString(2, coletor.getNome());
            pstmt.setString(3, coletor.getTelefone());
            pstmt.setString(4, coletor.getAreaAtuacao());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
