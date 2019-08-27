package com.bhrachan;

public class Dice
{
    public static int RollDice(A.eDice _dice)
    {
        double randomDouble = Math.random();
        randomDouble = randomDouble * GetMaxValue(_dice) + 1;
        int randomInt = (int) randomDouble;

        return randomInt;
    }

    private static int RollDiceAdd(A.eDice _dice, int _num)
    {
        int ret = 0;
        for(int i = _num; i > 0; i++)
        {
            ret += RollDice(_dice);
        }
        return ret;
    }

    private static int RollDisadvantage(A.eDice _dice, int _num)
    {
        int ret = RollDice(_dice);

        for(int i = _num - 1; i > 0; i++)
        {
            int tmp = RollDice(_dice);
            if(tmp < ret)
                ret = tmp;
        }

        return ret;
    }

    private static int RollAdvantage(A.eDice _dice, int _num)
    {
        int ret = RollDice(_dice);

        for(int i = _num - 1; i > 0; i++)
        {
            int tmp = RollDice(_dice);
            if(tmp > ret)
                ret = tmp;
        }

        return ret;
    }

    public static int Roll(A.eDice _dice, int _num, A.eDiceMode _diceMode)
    {
        int ret = 0;

        switch(_diceMode)
        {

            case add:
                ret = RollDiceAdd(_dice, _num);
                break;
            case advantage:
                ret = RollAdvantage(_dice, _num);
                break;
            case disadvantage:
                ret = RollDisadvantage(_dice, _num);
                break;
        }

        return ret;
    }

    public static int GetMaxValue(A.eDice _dice)
    {
        switch(_dice)
        {

            case d1:
                return 1;
            case d2:
                return 2;
            case d4:
                return 4;
            case d6:
                return 6;
            case d8:
                return 8;
            case d10:
                return 10;
            case d12:
                return 12;
            case d20:
                return 20;
            case d100:
                return 100;
            default:
                return 0;

        }
    }
}
