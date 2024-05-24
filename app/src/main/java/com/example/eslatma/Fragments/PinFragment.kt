package com.example.eslatma.Fragments


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.example.eslatma.Options.BaseFragment

import com.example.eslatma.databinding.PinFragmentBinding

class PinFragment(
    val pinArray: Array<Int> = arrayOf(0)
) : BaseFragment<PinFragmentBinding>() {


    override fun getIBinding(): PinFragmentBinding {
        return PinFragmentBinding.inflate(layoutInflater)
    }

    private fun CreatePinCode(int: Int) {
        pinArray.set(0, int)
    }

//     fun CheckPinCode(int: Int) {
//         if (pinArray.get(0)==0){
//             findNavController().popBackStack()
//         }
//        if ( int==pinArray.get(0)) {
//            findNavController().popBackStack()
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var input = 0
        var position = 0
        if (position <= 3) {
            if (position == 1) {
                binding.pin1.visibility = View.VISIBLE
            }
            if (position == 2) {
                binding.pin2.visibility = View.VISIBLE
            }
        }
        binding.pin1.setOnClickListener {
            if (position == 0) {
                input += 1
                position++
            } else if (position == 1) {
                input = input * 10 + 1
                position++
            } else if (position == 2) {
                input = input * 100 + 1
                position++
            } else if (position == 3) {
                input = input * 1000 + 1
                position++
            }
        }
        binding.pin2.setOnClickListener {
            if (position == 0) {
                input += 2
                position++
            } else if (position == 1) {
                input = input * 10 + 2
                position++
            } else if (position == 2) {
                input = input * 100 + 2
                position++
            } else if (position == 3) {
                input = input * 1000 + 2
                position++
            }
        }
        binding.pin3.setOnClickListener {
            if (position == 0) {
                input += 3
                position++
            } else if (position == 1) {
                input = input * 10 + 3
                position++
            } else if (position == 2) {
                input = input * 100 + 3
                position++
            } else if (position == 3) {
                input = input * 1000 + 3
                position++
            }
        }
        binding.pin4.setOnClickListener {
            if (position == 0) {
                input += 4
                position++
            } else if (position == 1) {
                input = input * 10 + 4
                position++
            } else if (position == 2) {
                input = input * 100 + 4
                position++
            } else if (position == 3) {
                input = input * 1000 + 4
                position++
            }
        }
        binding.pin5.setOnClickListener {
            if (position == 0) {
                input += 5
                position++
            } else if (position == 1) {
                input = input * 10 + 5
                position++
            } else if (position == 2) {
                input = input * 100 + 5
                position++
            } else if (position == 3) {
                input = input * 1000 + 5
                position++
            }
        }
        binding.pin6.setOnClickListener {
            if (position == 0) {
                input += 6
                position++
            } else if (position == 1) {
                input = input * 10 + 6
                position++
            } else if (position == 2) {
                input = input * 100 + 6
                position++
            } else if (position == 3) {
                input = input * 1000 + 6
                position++
            }
        }
        binding.pin7.setOnClickListener {
            if (position == 0) {
                input += 7
                position++
            } else if (position == 1) {
                input = input * 10 + 7
                position++
            } else if (position == 2) {
                input = input * 100 + 7
                position++
            } else if (position == 3) {
                input = input * 1000 + 7
                position++
            }
        }
        binding.pin8.setOnClickListener {
            if (position == 0) {
                input += 8
                position++
            } else if (position == 1) {
                input = input * 10 + 8
                position++
            } else if (position == 2) {
                input = input * 100 + 8
                position++
            } else if (position == 3) {
                input = input * 1000 + 8
                position++
            }
        }
        binding.pin9.setOnClickListener {
            if (position == 0) {
                input += 9
                position++
            } else if (position == 1) {
                input = input * 10 + 9
                position++
            } else if (position == 2) {
                input = input * 100 + 9
                position++
            } else if (position == 3) {
                input = input * 1000 + 9
                position++
            }
        }
        binding.pin0.setOnClickListener {
            if (position == 0) {
                input += 0
                position++
            } else if (position == 1) {
                input = input * 10 + 0
                position++
            } else if (position == 2) {
                input = input * 100 + 0
                position++
            } else if (position == 3) {
                input = input * 1000 + 0
                position++
            }
        }
        if (position == 3) {
            binding.pinCeck.setOnClickListener {
                CreatePinCode(input)
                println("$pinArray")
            }
        } else {
            binding.pinCeck.setOnClickListener {
                Toast.makeText(requireContext(), "4 xonali son kiristing", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        binding.pinClear.setOnClickListener {
            input = 0
            position = 0
        }
    }
}