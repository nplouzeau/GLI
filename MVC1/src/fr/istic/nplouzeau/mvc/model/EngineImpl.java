package fr.istic.nplouzeau.mvc.model;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;
import java.util.List;

/**
 * Created by plouzeau on 2014-09-18.
 */
public class EngineImpl implements Engine {

    private List<Candidate> candidates;
    private List<Candidate> selectedOneList;


    @Override
    public Iterator<Candidate> getCandidatesIterator() {
        return candidates.iterator();
    }

    @Override
    public Iterator<Candidate> getSelectedOnesIterator() {
        return selectedOneList.iterator();
    }

    /**
     * Moves a candidates at the end of the selected ones list.
     * Pre : newSelectedOne must be in the candidates list
     *
     * @param selectedOne the candidate to move
     * @throws java.lang.IllegalArgumentException if {@code selectedOne}
     *                                            is not in the candidates list.
     */
    @Override
    public void addToSelectedOnes(@NotNull Candidate selectedOne) {

        if ((selectedOne == null) || (!selectedOneList.contains(selectedOne))) {
                 throw new IllegalArgumentException("") ;
        }
    }
}
