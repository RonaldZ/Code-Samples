package geneticAlgorithmExample;


public class Chromosome {
	private static final int numGenes = 9;
	private Gene[] chromosome = new Gene[numGenes];
	private int target = 0;
	public double fitness = 1;
	private boolean viable = true;
	
	public Chromosome(int targetValue){
		target = targetValue;
		for(int i = 0; i < numGenes;i += 2)
			chromosome[i] = new Gene(true);
		for(int i = 1; i < numGenes;i += 2)
			chromosome[i] = new Gene(false);
		
		if(isViable()){
			fitness = determineFitness();
		}
		
	}

	public Gene[] getChromosome() {
		return chromosome;
	}

	public void setChromosome(Gene[] chromosome) {
		this.chromosome = chromosome;
	}

	public int getTarget() {
		return target;
	}
	
	public boolean getViable(){
		return viable;
	}

	public void setTarget(int value) {
		target = value;
	}
	
	public double getFitness(){
		return fitness;
	}
	
	//Assumes equation is viable.
	public double determineFitness(){
		double answer = 0;
		int[] numbers = new int[5];
		
		for(int i = 0;i < chromosome.length;i +=2)
			switch(chromosome[i].toString()){
			case "0000":
				numbers[i/2] = 0;
				break;
			case "0001":
				numbers[i/2] = 1;
				break;
			case "0010":
				numbers[i/2] = 2;
				break;
			case "0011":
				numbers[i/2] = 3;
				break;
			case "0100":
				numbers[i/2] = 4;
				break;
			case "0101":
				numbers[i/2] = 5;
				break;
			case "0110":
				numbers[i/2] = 6;
				break;
			case "0111":
				numbers[i/2] = 7;
				break;
			case "1000":
				numbers[i/2] = 8;
				break;
			case "1001":
				numbers[i/2] = 9;
				break;
			}
		answer = numbers[0];
		for(int i = 1; i < chromosome.length; i += 2)
			switch(chromosome[i].toString()){
			case "1010":
				answer = answer + numbers[(i+1)/2];
				break;
			case "1011":
				answer = answer - numbers[(i+1)/2];
				break;
			case "1100":
				answer = answer * numbers[(i+1)/2];
				break;
			case "1101":
				answer  = answer / numbers[(i+1)/2];
				break;
			}
		
		if((target - answer) == 0)
			answer = 0;
		else
			answer = 1/(target-answer);
		
		return answer;
	}
	
	public boolean isViable() {
		viable = true;
		
		for(int i = 1; i < chromosome.length && viable;i += 2)
			if(chromosome[i].toString().equals("1101"))
				if(chromosome[i+1].toString().equals("0000"))
					viable = false;
		
		return viable;
	}
	
	public String toString(){
		String temp = "";
		
		for(Gene i : chromosome){
			temp = temp + i.toString();
		}
		
		temp = temp + "\n";

		for(Gene i : chromosome){
			switch(i.toString()){
			case "0000":
				temp = temp + "0";
				break;
			case "0001":
				temp = temp + "1";
				break;
			case "0010":
				temp = temp + "2";
				break;
			case "0011":
				temp = temp + "3";
				break;
			case "0100":
				temp = temp + "4";
				break;
			case "0101":
				temp = temp + "5";
				break;
			case "0110":
				temp = temp + "6";
				break;
			case "0111":
				temp = temp + "7";
				break;
			case "1000":
				temp = temp + "8";
				break;
			case "1001":
				temp = temp + "9";
				break;
			case "1010":
				temp = temp + "+";
				break;
			case "1011":
				temp = temp + "-";
				break;
			case "1100":
				temp = temp + "*";
				break;
			case "1101":
				temp = temp + "/";
				break;
					
			}
		}
		return temp;
	}
}