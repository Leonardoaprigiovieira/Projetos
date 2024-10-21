package dao;

import cone.conexao;
import entify.usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class usuariodao {

    public void cadastarusuario(usuario usuario) {

        String sql = "INSERT INTO USUARIO (NOME, CPF, SALDOINICIAL, CREDITO) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conexao.getconexao().prepareStatement(sql);

            ps.setString(1, usuario.getNome());

            ps.setString(2, usuario.getcpf());

            ps.setString(3, usuario.getsaldoInicial());

            ps.setString(4, usuario.credito());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
