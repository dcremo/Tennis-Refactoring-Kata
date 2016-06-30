
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String mStrScore; // compute only if changed and store
    
    public TennisGame1(String player1Name, String player2Name) {
    	// TODO: validazione: notNull, notEquals
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        computeScore();
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            m_score1 += 1;
        }
        else {
            m_score2 += 1;
        }
        computeScore(); 
    }

    
    public String getScore() {
    	return mStrScore;
    }

    /**
     * String expression computation is quite tricky, do it once and store in field
     */
    private void computeScore() {
    	mStrScore = "";
        int tempScore=0;
        if (m_score1==m_score2)
        {
            switch (m_score1)
            {
                case 0:
                	mStrScore = "Love-All";
                    break;
                case 1:
                	mStrScore = "Fifteen-All";
                    break;
                case 2:
                	mStrScore = "Thirty-All";
                    break;
                default:
                	mStrScore = "Deuce";
                    break;
                
            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) mStrScore ="Advantage player1";
            else if (minusResult ==-1) mStrScore ="Advantage player2";
            else if (minusResult>=2) mStrScore = "Win for player1";
            else mStrScore ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { mStrScore+="-"; tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                    	mStrScore+="Love";
                        break;
                    case 1:
                    	mStrScore+="Fifteen";
                        break;
                    case 2:
                    	mStrScore+="Thirty";
                        break;
                    case 3:
                    	mStrScore+="Forty";
                        break;
                }
            }
        }
    }
}
