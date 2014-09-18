package fr.istic.nplouzeau.mvc.model;

import java.util.Iterator;

/**
 * Created by plouzeau on 2014-09-18.
 */
public interface Engine {

    /**
     * Returns an iterator to access the candidates list
     * @return
     */
    public Iterator<Candidate> getCandidatesIterator();

    /**
     * Returns an iterator to the selected candidates list
     * @return
     */
    Iterator<Candidate> getSelectedOnesIterator();

    /**
     * Moves a candidates at the end of the selected ones list.
     * Pre : newSelectedOne must be in the candidates list
     *
     * @param selectedOne the candidate to move
     * @throws java.lang.IllegalArgumentException if {@code selectedOne}
     * is not in the candidates list.
     */
    void addToSelectedOnes(Candidate selectedOne);
}
