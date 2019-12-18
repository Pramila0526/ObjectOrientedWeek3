package com.bridgelabz.deckofcards;

import java.util.Arrays;

import com.bridgelabz.utility.Utility;

/***************************************************************************************
 * @author :Pramila0526 
 * Purpose :Deck Of Cards Using LinkedQueue 
 * Date    :05/12/2019
 * 
 ***************************************************************************************/

public class DeckOfCardsUsingLinkedQueue 
{

	String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	String cards[] = { "Clubs", "Diamonds", "Hearts", "Spades" };

	int cardsLength = cards.length;
	int rankLength = rank.length;
	int cardsSize = cardsLength * rankLength;
	String deck[] = new String[cardsSize];
	int index = 0;
	String[][] deckIn2D = new String[cardsLength][rankLength];

	// Printing all Cards with its all combinations
	public void cardsCombinations() 
	{
		for (int i = 0; i < cardsLength; i++)
		{

			for (int j = 0; j < rankLength; j++) 
			{
				// Storing the cards combinations in deck[]
				deck[index] = cards[i] + " of " + rank[j];
				index++;
			}
		}
		System.out.println("======All Cards======");
		for (int i = 0; i < cardsSize; i++) 
		{
			// Printing the Cards
			System.out.println(" " + deck[i]);
			System.out.println("--------------------|");
		}
		System.out.println("Total cards are:- " + index);
	}

	// Code for shuffling the cards
	public void shufflingOfCards() 
	{
		for (int i = 0; i < cardsSize; i++)
		{
			// taking random number and then multiply it with the size
			// so we can get random cards which will be going to shuffle
			int shuffle = (int) (Math.random() * cardsSize);
			// Swapping of Cards
			String temp = deck[shuffle];
			deck[shuffle] = deck[i];
			deck[i] = temp;
		}
		System.out.println("\n===After Shuffling of Cards===\n");
		for (int i = 0; i < cardsSize; i++) 
		{
			// Printing of Cards After Shuffling
			System.out.println(" " + deck[i]);
			System.out.println("--------------------|");
		}
	}

	// code for distributing the cards to players
	public void distributingOfCards(int numberOfPlayers, int numberOfCards)
	{
		// a block of code to be tested for errors while it is being executed.
		try {
			for (int i = 0; i < numberOfPlayers; i++)
			{
				System.out.println("\n====Cards of Player" + (i + 1) + "====\n");
				for (int j = 0; j < numberOfCards; j++) 
				{
					deckIn2D[i][j] = deck[i + j * numberOfPlayers];
					// Storing in 2D array
					// deck[i+j*n1] it execute for loop and then multilpy it with the number
					// of players so that cards can distrubuted in the proper manner
					System.out.println(" " + deckIn2D[i][j]);
					System.out.println("--------------------|\n");
				}
			}
		}
		// a block of code to be executed, if an error occurs in the try block
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("Exception Occurs" + e);
		}
	}

	// Code For Sorting the cards Using LinkedQueue
	public void sortingOfCardsUsingLinkedQueue(int numberOfPlayers, int numberOfCards) 
	{
		String[] sortedCards = new String[numberOfCards];
		char[] array1 = new char[2];
		char[] array2 = new char[2];
		// Temporary Variables
		String temp1, temp2, temp3, temp4;
		for (int i = 0; i < numberOfPlayers; i++)
		{
			for (int j = 0; j < numberOfCards; j++) 
			{
				// Storing Of Sorted Cards
				sortedCards[j] = deck[i + j * numberOfPlayers];

			}

			for (int k = 0; k < sortedCards.length - 1; k++)
			{
				for (int j = 0; j < sortedCards.length - 1; j++)
				{
					temp1 = sortedCards[j];
					temp2 = sortedCards[j + 1];
					// array1[0] and array1[1] For Fetching last two letters
					array1[0] = temp1.charAt(temp1.length() - 2);
					array1[1] = temp1.charAt(temp1.length() - 1);
					// array2[0] and array2[1] For Fetching last two letters
					array2[0] = temp2.charAt(temp2.length() - 2);
					array2[1] = temp2.charAt(temp2.length() - 1);
					// comparing array1 and array2
					if (Arrays.compare(array1, array2) > 0) 
					{
						temp3 = sortedCards[j];
						sortedCards[j] = sortedCards[j + 1];
						sortedCards[j + 1] = temp3;
					}
				}
			}
			LinkedQueue.insert("For Player " + (i + 1) + " : \n");
			for (int j = 0; j < numberOfCards; j++) 
			{
				temp4 = sortedCards[j];
				// we can also print it with--System.out.print(temp4+"-->");
				LinkedQueue.insert(temp4 + "-->|"); //(-->|)because it is a linked Queue
			}
			LinkedQueue.insert("\n");
		}
		// printing the Linked Queue of Cards
		LinkedQueue.display();
	}

	public static void main(String[] args) {
		// Object of Class DeckOfCardsUsingLinkedQueue
		DeckOfCardsUsingLinkedQueue doc = new DeckOfCardsUsingLinkedQueue();

		doc.cardsCombinations();
		doc.shufflingOfCards();
		// Entering the Number Of Players
		System.out.println("\nEnter the number of Players");
		int numberOfPlayers = Utility.integerInput();
		// Entering  the Number Of cards
		System.out.println("Enter the number cards for each player");
		int numberOfCards = Utility.integerInput();

		doc.distributingOfCards(numberOfPlayers, numberOfCards);
		doc.sortingOfCardsUsingLinkedQueue(numberOfPlayers, numberOfCards);
	}
}