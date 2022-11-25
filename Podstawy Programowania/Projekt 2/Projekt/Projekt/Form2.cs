using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projekt
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (chart1.Series["Histogram"].IsVisibleInLegend == false)
                chart1.Series["Histogram"].IsVisibleInLegend = true;
            else
                chart1.Series["Histogram"].IsVisibleInLegend = false;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                colorDialog1.ShowHelp = true;
                chart1.Series["Histogram"].Color = colorDialog1.Color;
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Form1.typ = comboBox1.SelectedIndex;
            switch (Form1.typ)
            {
                case 0:
                    chart1.Series["Histogram"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Range;
                    break;
                case 1:
                    chart1.Series["Histogram"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Bubble;
                    break;
                case 2:
                    chart1.Series["Histogram"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Bar;
                    break;
                case 3:
                    chart1.Series["Histogram"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Column;
                    break;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form1.zaznaczone = checkBox1.Checked;
            Form1.typ = comboBox1.SelectedIndex;
            Form1.kolor = colorDialog1.Color;
            this.Close();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            checkBox1.Checked = Form1.zaznaczone;
            colorDialog1.Color = Form1.kolor;
            comboBox1.SelectedIndex = Form1.typ;

            string[] wynik = Form1.Informacje.Split(new char[] { ':', '\n' });
            for (int i = 0; i < wynik.Length; i++)
            {
                chart1.Series["Histogram"].Points.AddXY(Convert.ToString(wynik[i]), Convert.ToString(wynik[i + 1]));
                i++;
            }
        }
    }
}
