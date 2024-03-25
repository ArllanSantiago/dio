using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ControleEstacionamento.Models
{
    public class Estacionamento
    {
        private decimal precoInicial = 0;
        private decimal precoPorHora = 0;
        private List<string> veiculos = new List<string>();


        public Estacionamento(decimal precoInicial, decimal precoPorHora){
            this.precoInicial = precoInicial;
            this.precoPorHora = precoPorHora;
        }
        public void definirPrecos(){
            Console.WriteLine("Digite o preço inicial do estacionamento");
            this.precoInicial = decimal.Parse(Console.ReadLine());
            Console.WriteLine("Digite o preço por hora estacionamenta");
            this.precoPorHora = decimal.Parse(Console.ReadLine());
        }
        public void AdicionarVeiculo(){
        string placa = string.Empty;
            Console.WriteLine("Digite a placa do veículo para estacionar:");
            placa = Console.ReadLine();

            this.veiculos.Add(placa.ToUpper());
        }
        public void RemoverVeiculo(){
            
            Console.WriteLine("Digite a placa do veiculo para remove-lo: ");
            string placa = string.Empty;
            placa = Console.ReadLine();

            if (this.veiculos.Any(v => v.ToUpper() == placa.ToUpper()))
            {
                int horas = 0;
                decimal valorTotal = 0;

                Console.WriteLine("Digite a quantidade de horas que o veículo permaneceu estacionado:");

                horas = int.Parse(Console.ReadLine());                
                valorTotal = this.precoInicial + (this.precoPorHora* horas); 

                
                this.veiculos.Remove(placa.ToUpper());

                Console.WriteLine($"O veículo {placa} foi removido e o preço total foi de: R$ {valorTotal}");
            }
            else
            {
                Console.WriteLine("Desculpe, esse veículo não está estacionado aqui. Confira se digitou a placa corretamente");
            }

        }
        public void ListarVeiculos(){
            if(this.veiculos.Any()){
                Console.WriteLine("Os Veículos estacionados são:");
                this.veiculos.ForEach(v => Console.WriteLine(v));
            }else{
                Console.WriteLine("Não há veículos estacionados.");
            }
        }
    }
}