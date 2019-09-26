package com.project.one.ui.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.project.one.R;

import static com.project.one.ui.main.Calculator.Operation.PLUS;
import static com.project.one.ui.main.Calculator.whatToDo.NOTHING;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculator extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    enum Operation {
        PLUS, MINUS, MULTIPLY, DIVIDE, NOTHING;
    }

    private int buffer, memory;
    private Operation whatToDo;

    public Calculator() {
        this.buffer = 0;
        this.memory = 0;
        this.whatToDo = NOTHING;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculator.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculator newInstance() {
        Calculator fragment = new Calculator();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public static CharSequence getTitle() {
        return "Calculator";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        view.findViewById(R.id.one).setOnClickListener(v -> {
            typeNumber((short) 1);
        });
        view.findViewById(R.id.two).setOnClickListener(v -> {
            typeNumber((short) 2);
        });
        view.findViewById(R.id.three).setOnClickListener(v -> {
            typeNumber((short) 3);
        });
        view.findViewById(R.id.four).setOnClickListener(v -> {
            typeNumber((short) 4);
        });
        view.findViewById(R.id.five).setOnClickListener(v -> {
            typeNumber((short) 5);
        });
        view.findViewById(R.id.six).setOnClickListener(v -> {
            typeNumber((short) 6);
        });
        view.findViewById(R.id.seven).setOnClickListener(v -> {
            typeNumber((short) 7);
        });
        view.findViewById(R.id.eight).setOnClickListener(v -> {
            typeNumber((short) 8);
        });
        view.findViewById(R.id.nine).setOnClickListener(v -> {
            typeNumber((short) 9);
        });
        view.findViewById(R.id.delete).setOnClickListener(v -> {
            this.buffer = this.buffer / 10;
        });
        view.findViewById(R.id.clear).setOnClickListener(v -> {
            this.buffer = 0;
            this.memory = 0;
        });
        view.findViewById(R.id.equals).setOnClickListener(v -> {
            doEquals();
        });
        view.findViewById(R.id.divided).setOnClickListener(v -> {
            if (this.whatToDo != NOTHING) {
                doEquals();
            }
            this.memory = this.buffer;
        });

        return view;
    }

    private void doEquals() {
        switch (this.whatToDo) {
            case PLUS:
                this.buffer = this.memory + this.buffer;
                break;
            case MINUS:
                this.buffer = this.memory - this.buffer;
                break;
            case MULTIPLY:
                this.buffer = this.memory * this.buffer;
                break;
            case DIVIDE:
                this.buffer = this.memory / this.buffer;
                break;
            case NOTHING:
                break;
            default:
                Snackbar.make(view, "A fatal error has occurred", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
        }
        this.memory = 0;
        this.whatToDo = NOTHING;
    }

    private void typeNumber(short number) {
        this.buffer = this.buffer * 10 + number;
    }
}
