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
import androidx.annotation.NonNull; // Add this import

public class DosenPembimbingFragment extends Fragment {

    private RecyclerView recyclerView;
    private Button btnTambahData;
    private DosenAdapter dosenAdapter;
    private List<Dosen> dosenList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dosen_pembimbing, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewMahasiswa);
        btnTambahData = view.findViewById(R.id.buttonTambahData);

        // Dummy Data
        dosenList.add(new Dosen("PIZAINI, S.T., M.Kom.", "1234567890", "Laki-laki", "Software Development", "5"));
        dosenList.add(new Dosen("Iwan Iskandar, M.T.", "0987654321", "Laki-laki", "Jaringan", "4"));
        dosenList.add(new Dosen("FITRI INSANI, S.T., M.Kom.", "1234567890", "Perempuan", "Kalkulus", "5"));
        


        // Initialize RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dosenAdapter = new DosenAdapter(dosenList);
        recyclerView.setAdapter(dosenAdapter);

        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
            }
        });

        return view;
    }

    public static class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.DosenViewHolder> {

        private List<Dosen> dosenList;

        public DosenAdapter(List<Dosen> dosenList) {
            this.dosenList = dosenList;
        }

        @NonNull
        @Override
        public DosenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dosen_item, parent, false);
            return new DosenViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DosenViewHolder holder, int position) {
            Dosen dosen = dosenList.get(position);
            holder.txtNama.setText(dosen.getNama());
            holder.txtNIDN.setText(dosen.getNidn());
            holder.txtJenisKelamin.setText(dosen.getJenisKelamin());
            holder.txtKeahlian.setText(dosen.getKeahlian());
            holder.txtKuota.setText(dosen.getKuota());
        }

        @Override
        public int getItemCount() {
            return dosenList.size();
        }

        public static class DosenViewHolder extends RecyclerView.ViewHolder {

            private TextView txtNama, txtNIDN, txtJenisKelamin, txtKeahlian, txtKuota;

            public DosenViewHolder(@NonNull View itemView) {
                super(itemView);
                txtNama = itemView.findViewById(R.id.txtNama);
                txtNIDN = itemView.findViewById(R.id.txtNIDN);
                txtJenisKelamin = itemView.findViewById(R.id.txtJenisKelamin);
                txtKeahlian = itemView.findViewById(R.id.txtKeahlian);
                txtKuota = itemView.findViewById(R.id.txtKuota);
            }
        }
    }

    public static class Dosen {

        private String nama;
        private String nidn;
        private String jenisKelamin;
        private String keahlian;
        private String kuota;

        public Dosen(String nama, String nidn, String jenisKelamin, String keahlian, String kuota) {
            this.nama = nama;
            this.nidn = nidn;
            this.jenisKelamin = jenisKelamin;
            this.keahlian = keahlian;
            this.kuota = kuota;
        }

        public String getNama() {
            return nama;
        }

        public String getNidn() {
            return nidn;
        }

        public String getJenisKelamin() {
            return jenisKelamin;
        }

        public String getKeahlian() {
            return keahlian;
        }

        public String getKuota() {
            return kuota;
        }
    }
}
