/**
 * Implementazione
 * 
 * @author Davide
 *
 */
public class TennisGame1 implements TennisGame {

	private static final String LOVE = "Love";
	private static final String FIFTEEN = "Fifteen";
	private static final String THIRTY = "Thirty";
	private static final String FORTY = "Forty";
	private static String[] strPoints = { LOVE, FIFTEEN, THIRTY, FORTY };

	private static final String ALL = "All";
	private static final String DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage ";
	private static final String WIN_FOR = "Win for ";

	private int m_score1 = 0;
	private int m_score2 = 0;
	private String player1Name;
	private String player2Name;
	private String mStrScore; // compute only if changed and store


	public TennisGame1(String player1Name, String player2Name) {
		// TODO: validazione casi patologici: notNull, notEquals
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		computeScore();
	}

	public void wonPoint(String playerName) {
		if (player1Name.equals(playerName)) {
			m_score1 += 1;
		} else {
			m_score2 += 1;
		}
		computeScore();
	}

	public String getScore() {
		return mStrScore;
	}

	/**
	 * String expression computation is quite tricky, do it once and store in
	 * field
	 */
	private void computeScore() {
		mStrScore = "";
		int tempScore = 0;
		if (m_score1 == m_score2) {
			if (m_score1 < 3) {
				mStrScore = strPoints[m_score1] + "-" + ALL;
			} else {
				mStrScore = DEUCE;
			}
		} else if (m_score1 >= 4 || m_score2 >= 4) {
			int minusResult = m_score1 - m_score2;
			if (minusResult == 1) {
				mStrScore = ADVANTAGE + player1Name;
			} else if (minusResult == -1) {
				mStrScore = ADVANTAGE + player2Name;
			} else if (minusResult >= 2) {
				mStrScore = WIN_FOR + player1Name;
			} else {
				mStrScore = WIN_FOR + player2Name;
			}
		} else {
			mStrScore = strPoints[m_score1] + "-" + strPoints[m_score2];
		}
	}
}
