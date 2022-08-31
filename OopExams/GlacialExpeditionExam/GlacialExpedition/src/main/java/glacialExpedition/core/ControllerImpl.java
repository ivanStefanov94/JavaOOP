package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final StateRepository stateRepository;
    private final ExplorerRepository explorerRepository;
    private int countExploredStates;

    public ControllerImpl(){
        this.stateRepository = new StateRepository();
        this.explorerRepository = new ExplorerRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;

        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        state.getExhibits().addAll(Arrays.asList(exhibits));
        this.stateRepository.add(state);

        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        if(this.explorerRepository.getCollection().stream().noneMatch(a -> a.getName().equals(explorerName))){
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        Explorer explorerToRemove = this.explorerRepository.byName(explorerName);
        this.explorerRepository.remove(explorerToRemove);

        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> suitableExplorers = this.explorerRepository.getCollection().stream()
                .filter(a -> a.getEnergy() > 50).collect(Collectors.toList());

        if(suitableExplorers.isEmpty()){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        int countBefore = suitableExplorers.size();

        Mission mission = new MissionImpl();
        State state = this.stateRepository.byName(stateName);
        mission.explore(state, suitableExplorers);
        countExploredStates++;
        int countAfter = suitableExplorers.size();

        return String.format(STATE_EXPLORER, stateName, countBefore - countAfter);
    }

    @Override
    public String finalResult() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(FINAL_STATE_EXPLORED, countExploredStates)).append(System.lineSeparator());
        builder.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        this.explorerRepository.getCollection().forEach(e -> {
            builder.append(String.format(FINAL_EXPLORER_NAME, e.getName())).append(System.lineSeparator());
            builder.append(String.format(FINAL_EXPLORER_ENERGY, e.getEnergy())).append(System.lineSeparator());

            if(e.getSuitcase().getExhibits().isEmpty()){
                builder.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            }else{
                Collection<String> exhibits = e.getSuitcase().getExhibits();
                builder.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, exhibits)))
                        .append(System.lineSeparator());
            }

        });

        return builder.toString().trim();
    }
}
