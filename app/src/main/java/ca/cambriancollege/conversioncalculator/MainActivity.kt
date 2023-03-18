package ca.rishabhBhutani.conversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import ca.cambriancollege.conversioncalculator.R

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var spinner1: Spinner
    private lateinit var input : EditText
    private lateinit var result: TextView
    private lateinit var buttonConvert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById<EditText>(R.id.editText1)
        spinner = findViewById<Spinner>(R.id.spinner1)
        spinner1 = findViewById<Spinner>(R.id.spinner2)
        buttonConvert = findViewById<Button>(R.id.submitbutton)
        result = findViewById<TextView>(R.id.editText2)

        var enteries = mutableListOf("Miles", "KM", "Meter", "CM", "Millimeter", "Inches")
        val arrayAdapter = ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, enteries)

        spinner.adapter = arrayAdapter
        spinner1.adapter = arrayAdapter

        buttonConvert.setOnClickListener {
            convert()
        }
    }

    private fun convert() {

        val milestoKm : Double = 1.60934
        val mtoInch : Double = 63360.0
        val kmtoM : Double = 1000.00
        val kmtoInch : Double = 39370.1
        val metertoCm : Double = 100.00
        val metertoInch : Double = 39.37
        val cmtoMm : Double = 10.00
        val cmtoInch : Double = 0.393701
        val mmtoInch : Double = 0.0393701
        val inchtoMile : Double = 6360.0
        val inches : Double = 2.54

        val inputVal = input.text.toString()
        if(inputVal.isEmpty()) {
            Toast.makeText(this, "Please enter a valid input value", Toast.LENGTH_SHORT).show()
            return
        }

        val input = inputVal.toDouble()
        val from = spinner.selectedItem.toString()
        val to = spinner1.selectedItem.toString()

        var output = when {
            from == "Miles" && to == "KM" -> input * milestoKm
            from == "Miles" && to == "Meter" -> input * milestoKm * kmtoM
            from == "Miles" && to == "CM" -> input * milestoKm * kmtoM * metertoCm
            from == "Miles" && to == "millimeter" -> input * milestoKm * kmtoM * metertoCm * cmtoMm
            from == "Miles" && to == "Inches" -> input * mtoInch
            from == "KM" && to == "Miles" -> input / milestoKm
            from == "KM" && to == "Meter" -> input * kmtoM
            from == "KM" && to == "CM" -> input * kmtoM * metertoCm
            from == "KM" && to == "Millimeter" -> input * kmtoM * metertoCm * cmtoMm
            from == "KM" && to == "Inches" -> input * kmtoInch
            from == "Meter" && to == "Miles" -> input / milestoKm
            from == "Meter" && to == "KM" -> input / kmtoM
            from == "Meter" && to == "CM" -> input * metertoCm
            from == "Meter" && to == "Millimeter" -> input * metertoCm * cmtoMm
            from == "Meter" && to == "Inches" -> input * metertoInch
            from == "CM" && to == "Miles" -> input / metertoCm / kmtoM / milestoKm
            from == "CM" && to == "KM" -> input / metertoCm / kmtoM
            from == "CM" && to == "Meter" -> input / metertoCm
            from == "CM" && to == "Millimeter" -> input * cmtoMm
            from == "CM" && to == "Inches" -> input * cmtoInch
            from == "Millimeter" && to == "Miles" -> input / cmtoMm/ metertoCm / kmtoM / milestoKm
            from == "Millimeter" && to == "KM" -> input / cmtoMm/ metertoCm / kmtoM
            from == "Millimeter" && to == "Meter" -> input / cmtoMm/ metertoCm
            from == "Millimeter" && to == "CM" -> input / cmtoMm
            from == "Millimeter" && to == "Inches" -> input * mmtoInch
            from == "Inches" && to == "Miles" -> input * inchtoMile
            from == "Inches" && to == "KM" -> (input * 0.0254)/kmtoM
            from == "Inches" && to == "Meter" -> input * 0.0254
            from == "Inches" && to == "CM" -> input * inches
            else -> input
        }
        result.text = String.format("%.2f", output)

    }
}



