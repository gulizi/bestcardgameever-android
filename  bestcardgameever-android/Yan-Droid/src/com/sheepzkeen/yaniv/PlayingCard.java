package com.sheepzkeen.yaniv;

import java.lang.reflect.Field;


public class PlayingCard {
	
	//suits
	protected static final char HEARTS = 'h';
	protected static final char SPADES = 's';
	protected static final char CLUBS = 'c';
	protected static final char DIAMOND = 'd';
	//tens
	protected static final char JACK = 'j';
	protected static final char QUEEN = 'q';
	protected static final char KING = 'k';
	protected static final char TEN = 't';
	//others
	protected static final char BLACK_SUIT = 'b';
	protected static final char RED_SUIT = 'r';
	protected static final char JOKER = 'o';
	
	
	private char suit;
	private char value;
	private boolean isVisible;
	
	
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public char getValue() {
		return value;
	}
	public void setSuit(char suit) {
		this.suit = suit;
	}
	public char getSuit() {
		return suit;
	}

	public String getPngName() {
		return new String(new char[]{suit,value});
	}
	
	public PlayingCard(char suit, char value) {
		super();
		this.suit = suit;
		this.value = value;
	}
	
	public int getImageResourceId(){
		Field f;
		int id = -1;
		try {
			f = R.drawable.class.getDeclaredField(getPngName());
			id = f.getInt(null);
			//TODO: Add logging!
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * Returns the value of the card with some exceptions
	 * J, Q, K are each worth 10
	 * Joker (o) is worth 0
	 * @return the value of this card.
	 */
	public int getIntValue(){
		int retVal = Character.getNumericValue(this.value);
		switch (value) {
			case TEN:
			case JACK:
			case QUEEN:
			case KING:
				retVal = 10;
				break;
			case JOKER:
				retVal = 0;
			default:
				break;
			}
		
		return retVal;
	}
@Override
public String toString() {
	return new String(new char[]{getSuit(),getValue()});
}
}