package belajarswing;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Yanu
 */
public class MahasiswaController {
    public void simpanData(Mahasiswa m) throws SQLException{
        String strSQL = "INSERT INTO MAHASISWA (NIM, NAMA, JURUSAN) VALUES (?,?,?)";
        Connection koneksi = Koneksi.getKoneksi();
        PreparedStatement ps = koneksi.prepareCall(strSQL);
        ps.setString(1, m.getNim());
        ps.setString(2, m.getNama());
        ps.setString(3, m.getJurusan());
        ps.executeUpdate();
        ps.close();
        koneksi.close();
    }
    
    public List<Mahasiswa> ambilSemuaData() throws SQLException {
        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        
        Connection koneksi;
        try {
            String strSQL = "SELECT * FROM mahasiswa";
            koneksi = Koneksi.getKoneksi();

            Statement st = koneksi.createStatement();
            ResultSet hasil = st.executeQuery(strSQL);
            while (hasil.next())
            {
                Mahasiswa ms = new Mahasiswa();
                ms.setNim(hasil.getString("NIM"));
                ms.setNama(hasil.getString("NAMA"));
                ms.setJurusan(hasil.getString("JURUSAN"));
                daftarMahasiswa.add(ms);
            }
            koneksi.close();
          } catch (SQLException ex) {
            Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
          }
        return daftarMahasiswa;
    }
}
