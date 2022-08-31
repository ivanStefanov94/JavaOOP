package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{
    @Override
    public void explore(State state, List<Explorer> explorers) {
        for (int i = 0; i < explorers.size(); i++) {
            Explorer currentExplorer =explorers.get(i);

            for (int exhibit = 0; exhibit < state.getExhibits().size(); exhibit++) {
                String currentExhibit = state.getExhibits().get(exhibit);
                currentExplorer.getSuitcase().getExhibits().add(currentExhibit);
                state.getExhibits().remove(currentExhibit);
                exhibit--;

                currentExplorer.search();

                if(!currentExplorer.canSearch()){
                    explorers.remove(currentExplorer);
                    i--;
                    break;
                }
            }
        }
        

    }
}
