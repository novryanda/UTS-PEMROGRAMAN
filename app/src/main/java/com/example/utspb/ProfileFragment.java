package com.example.utspb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private ImageView imgProfile;
    private TextView txtNama, txtNIM, txtUmur, txtTempatTanggalLahir, txtAlamat, txtJenisKelamin, txtEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imgProfile = view.findViewById(R.id.imgProfile);
        txtNama = view.findViewById(R.id.txtNama);
        txtNIM = view.findViewById(R.id.txtNIM);
        txtUmur = view.findViewById(R.id.txtUmur);
        txtTempatTanggalLahir = view.findViewById(R.id.txtTempatTanggalLahir);
        txtAlamat = view.findViewById(R.id.txtAlamat);
        txtJenisKelamin = view.findViewById(R.id.txtJenisKelamin);
        txtEmail = view.findViewById(R.id.txtEmail);

        // Set dummy data
//        imgProfile.setImageResource(R.drawable.profile_placeholder);
//        txtNama.setText("John Doe");
//        txtNIM.setText("1234567890");
//        txtUmur.setText("25");
//        txtTempatTanggalLahir.setText("Jakarta, 01 Januari 1999");
//        txtAlamat.setText("Jl. ABC No. 123, Jakarta");
//        txtJenisKelamin.setText("Laki-laki");
//        txtEmail.setText("johndoe@example.com");

        return view;
    }
}
