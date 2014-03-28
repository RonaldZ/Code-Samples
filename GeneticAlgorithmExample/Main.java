package geneticAlgorithmExample;
import java.util.Scanner;

public class Main {
	private final int numChromosomes = 100;
	private Chromosome[] chromosomes = new Chromosome[numChromosomes];
	private int target;
	
	
	public Main(int target){
		this.target = target;
		for(int i = 0;i< numChromosomes;i++)
			chromosomes[i] = new Chromosome(target);
	}
	
	public void run(){
		Chromosome[] newChromosomes = new Chromosome[numChromosomes];
		Chromosome test = test();
		while(test == null){
			
			newChromosomes[0] = roulette();
			newChromosomes[1] = roulette();
			
			crossover(newChromosomes[0], newChromosomes[1]);
			
			for(int i = 2; i < numChromosomes; i++){
				newChromosomes[i] = new Chromosome(target);
			}
			
			chromosomes = newChromosomes;
			
			test = test();
		}
		
		System.out.println("A suitable chromosome is: \n" + test.toString());
		
		
	}
	
	//determines if we've found a solution for our target answer.
	public Chromosome test(){
		for(Chromosome i : chromosomes){
			if(i.getViable())
				if(i.getFitness() == 0)
					return i;
		}
		
		return null;

	}
	
	public Chromosome roulette(){
		double total = 0;
		double[] temp = new double[numChromosomes];
		
		for(int i = 0; i < numChromosomes; i++){
			total += Math.abs(chromosomes[i].getFitness());
			temp[i] = total;
		}
		
		double randChromosome = Math.random() * total;
		
		for(int i = 0; i < numChromosomes; i++){
			if(randChromosome < temp[i]){
				return chromosomes[i];
			}
		}
		
		return null;
	}
	
	public void crossover(Chromosome chromosome1, Chromosome chromosome2){
		int randInt = (int) (Math.random() * 36);
		
		for(int i = 0;i < 9; i++){
			for(int j = 0; j < 4; j++)
				if(i < randInt){
					if(Math.random() < .7)
						chromosome1.getChromosome()[i].getGene()[j] = chromosome2.getChromosome()[i].getGene()[j];
				}
				else{
					if(Math.random() < .7)
						chromosome2.getChromosome()[i].getGene()[j] = chromosome1.getChromosome()[i].getGene()[j];
				}
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter an integer, and I will find an equation for it");
		System.out.print(">>");
		Main runner = new Main(scan.nextInt());
		System.out.println("Order of Operations will be from left to right");
		
		runner.run();
		scan.close();
	}
}
