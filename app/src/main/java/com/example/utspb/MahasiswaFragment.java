package com.example.utspb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;


public class MahasiswaFragment extends Fragment {

    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private List<Mahasiswa> mahasiswaList = new ArrayList<>();
    private List<Dosen> dosenList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mahasiswa, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewMahasiswa);
        mahasiswaAdapter = new MahasiswaAdapter(mahasiswaList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mahasiswaAdapter);

        // Load data (For demonstration, using dummy data)
        loadDummyData();

        Button buttonTambahData = view.findViewById(R.id.buttonTambahData);
        buttonTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show modal or navigate to add data activity
            }
        });
    }

    private void loadDummyData() {
        mahasiswaList.add(new Mahasiswa("20-04-2024", "Abmi Sukma Edri", "12050120341", "Abmi@example.com", "Sample Title", "menunggu"));
        mahasiswaList.add(new Mahasiswa("20-04-2024", "Ahmad Kurniawan", "12250111514", "Ahmad@example.com", "Sample Title 2", "menunggu"));
        mahasiswaList.add(new Mahasiswa("20-04-2024", "Aufa Hajati", "12250120338", "Aufa@example.com", "Sample Title", "menunggu"));
        mahasiswaList.add(new Mahasiswa("20-04-2024", "Daffa Finanda", "12250111603", "Daffa@example.com", "Sample Title 2", "menunggu"));
        mahasiswaList.add(new Mahasiswa("20-04-2024", "Daffa Ikhwan Nurfauzan", "12250110979", "Ikhwan@example.com", "Sample Title", "menunggu"));
        mahasiswaList.add(new Mahasiswa("20-04-2024", "Dwi Jelita Adhliyah", "12250120331", "Dwi@example.com", "Sample Title 2", "menunggu"));

        dosenList.add(new Dosen("1", "Dr. Pembimbing 1"));
        dosenList.add(new Dosen("2", "Dr. Pembimbing 2"));
    }

    // RecyclerView Adapter for Mahasiswa
    private class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaViewHolder> {

        private List<Mahasiswa> mahasiswaList;

        MahasiswaAdapter(List<Mahasiswa> mahasiswaList) {
            this.mahasiswaList = mahasiswaList;
        }

        @Override
        public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_item, parent, false);
            return new MahasiswaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MahasiswaViewHolder holder, int position) {
            Mahasiswa mahasiswa = mahasiswaList.get(position);
            holder.bindData(mahasiswa);
        }

        @Override
        public int getItemCount() {
            return mahasiswaList.size();
        }
    }

    // ViewHolder for Mahasiswa
    private static class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTanggal, txtNama, txtNIM, txtEmail, txtJudul, txtStatus;

        MahasiswaViewHolder(View itemView) {
            super(itemView);

            txtTanggal = itemView.findViewById(R.id.txtTanggal);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtNIM = itemView.findViewById(R.id.txtNIM);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtJudul = itemView.findViewById(R.id.txtJudul);
            txtStatus = itemView.findViewById(R.id.txtStatus);
        }

        void bindData(Mahasiswa mahasiswa) {
            txtTanggal.setText(mahasiswa.getTanggal());
            txtNama.setText(mahasiswa.getNama());
            txtNIM.setText(mahasiswa.getNIM());
            txtEmail.setText(mahasiswa.getEmail());
            txtJudul.setText(mahasiswa.getJudul());
            txtStatus.setText(mahasiswa.getStatus());
        }
    }

    // Dummy Mahasiswa class
    private static class Mahasiswa {
        private String tanggal, nama, NIM, email, judul, status;

        Mahasiswa(String tanggal, String nama, String NIM, String email, String judul, String status) {
            this.tanggal = tanggal;
            this.nama = nama;
            this.NIM = NIM;
            this.email = email;
            this.judul = judul;
            this.status = status;
        }

        String getTanggal() {
            return tanggal;
        }

        String getNama() {
            return nama;
        }

        String getNIM() {
            return NIM;
        }

        String getEmail() {
            return email;
        }

        String getJudul() {
            return judul;
        }

        String getStatus() {
            return status;
        }
    }

    // Dummy Dosen class
    private static class Dosen {
        private String id, nama;

        Dosen(String id, String nama) {
            this.id = id;
            this.nama = nama;
        }

        String getId() {
            return id;
        }

        String getNama() {
            return nama;
        }
    }
}
