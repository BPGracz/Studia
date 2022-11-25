using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Projekt
{
    public partial class Form1 : Form
    {
        public static int grupydol = 100, grupygora = 0, ilegrup = 0, typ;
        public static bool ifserie = true;
        public static string zawartoscplik = "", Informacje;
        public static bool zaznaczone;
        public static Color kolor;


        private void button3_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            saveFileDialog1.Filter = "txt files (*.txt)|*.txt";
            saveFileDialog1.FilterIndex = 2;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                String zapisDirectory = saveFileDialog1.InitialDirectory;
                String zapisFileName = saveFileDialog1.FileName;
                String sciezka = Path.Combine(zapisDirectory, zapisFileName);

                using (StreamWriter zapisz = new StreamWriter(sciezka))
                {
                    zapisz.WriteLine(groupBox2.Text + " " + textBox2.Text);
                    zapisz.WriteLine(groupBox5.Text);
                    zapisz.WriteLine(textBox3.Text);
                    zapisz.Close();
                }

                if (File.Exists(sciezka)) MessageBox.Show("Plik zapisano pomyślnie.", "Gratulacje!", MessageBoxButtons.OK, MessageBoxIcon.Information);
                else MessageBox.Show("Błąd przy zapisie pliku.", "ARGH!", MessageBoxButtons.OK, MessageBoxIcon.Error);

            }
        }

        public static bool check1;

        private void button2_Click(object sender, EventArgs e)
        {
            Form2 otworz = new Form2();
            otworz.ShowDialog();
        }

        public static Color kolortla;

        public Form1()
        {
            InitializeComponent();

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.InitialDirectory = "c:\\";
                openFileDialog.Filter = "txt files (*.txt)|*.txt";
                openFileDialog.FilterIndex = 2;
                openFileDialog.RestoreDirectory = true;

                if (openFileDialog.ShowDialog() == DialogResult.OK)
                {
                    //Ścieżka do pliku, którą podaje użytkownik
                    string droga = openFileDialog.FileName;

                    if (openFileDialog.CheckFileExists)
                    {
                        //Odczytanie zawartości pliku
                        zawartoscplik = File.ReadAllText(droga);
                        try
                        {
                            WyswietlDane();
                            button2.Enabled = true;
                            button3.Enabled = true;
                            textBox1.Enabled = false;
                            textBox2.Enabled = false;
                        }
                        catch
                        {
                            MessageBox.Show("Niewłaściwe dane w pliku.", "ARGH!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                    else MessageBox.Show("Nie można otworzyć pliku.", "ARGH!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        public void WyswietlDane()
        {
            //------------------------------------
            //Resetowanie wcześniejszych ustawień
            textBox1.Text = null;
            textBox2.Text = null;
            textBox3.Text = null;
            grupydol = 999;
            grupygora = 0;
            //------------------------------------

            textBox1.Text = zawartoscplik;
            string[] wynik = zawartoscplik.Split(';');
            Double ocena;
            int k = 0;
            Double[] tablicaOcen = new Double[wynik.Length - 2];

            foreach (var value in wynik)
            {
                Double.TryParse(value, out ocena);
                if (ocena < grupydol) grupydol = Convert.ToInt32(Math.Floor(ocena));
                if (ocena > grupygora) grupygora = Convert.ToInt32(Math.Ceiling(ocena));
                if (Double.TryParse(value, out ocena))
                {
                    tablicaOcen[k] = ocena;
                    k++;
                }
            }

            ilegrup = grupygora - grupydol;
            textBox2.Text = Convert.ToString(ilegrup);

            //Sprawdzenie czy działa tablica z ocenami
            //for(int i = 0; i < tablicaOcen.Length; i++) textBox3.Text = Convert.ToString(tablicaOcen[i]);

            //--------------------------------------------------

            //Sortowanie Ocen
            double temp = 0;
            for (int i = 0; i < tablicaOcen.Length; i++)
            {
                for (int j = 0; j < tablicaOcen.Length - 1; j++)
                {
                    if (tablicaOcen[j] > tablicaOcen[j + 1])
                    {
                        temp = tablicaOcen[j + 1];
                        tablicaOcen[j + 1] = tablicaOcen[j];
                        tablicaOcen[j] = temp;
                    }
                }
            }
            //--------------------------------------------------

            //Liczenie ile jest ocen w poszczególnych grupach 
            Double dol = grupydol;
            int iloscOcen = 0;
            for (int i = 0; i < tablicaOcen.Length; i++)
            {
                if (Math.Floor(tablicaOcen[i]) == dol)
                {
                    iloscOcen++;
                }
                else
                {
                    textBox3.Text = textBox3.Text + Convert.ToString(dol) + "-" + Convert.ToString(dol + 1) + ": " + Convert.ToString(iloscOcen) + Environment.NewLine;
                    iloscOcen = 0;
                    dol++;
                    i--;
                }
            }
            textBox3.Text = textBox3.Text + Convert.ToString(dol) + "-" + Convert.ToString(dol + 1) + ": " + Convert.ToString(iloscOcen);
            Informacje = textBox3.Text;
            //--------------------------------------------------

            MessageBox.Show("Plik wczytano pomyślnie.", "Gratulacje!", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}
