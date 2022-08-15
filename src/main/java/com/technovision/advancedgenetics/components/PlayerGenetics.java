package com.technovision.advancedgenetics.components;

import com.technovision.advancedgenetics.api.components.GeneticsComponent;
import com.technovision.advancedgenetics.api.genetics.Genes;
import net.minecraft.nbt.NbtCompound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerGenetics implements GeneticsComponent {

    private final Map<String, Genes> genes = new HashMap<>();

    @Override
    public void readFromNbt(NbtCompound tag) {
        NbtCompound genesTag = tag.getCompound("genes");
        for (String geneName : genesTag.getKeys()) {
            Genes gene = Genes.valueOf(geneName);
            genes.put(geneName, gene);
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        NbtCompound genesTag = new NbtCompound();
        for (Genes gene : genes.values()) {
            genesTag.putString(gene.toString(), gene.getName());
        }
        tag.put("genes", genesTag);
    }

    @Override
    public void serverTick() {
        // TODO: Implement
    }

    @Override
    public int geneCount() {
        return genes.size();
    }

    @Override
    public List<Genes> getGenes() {
        return genes.values().stream().toList();
    }

    @Override
    public Map<String, Genes> getGenesMap() {
        return genes;
    }

    @Override
    public Genes getGeneByName(String name) {
        for (Genes gene : Genes.values()) {
            if (gene.getName().equals(name)) return gene;
        }
        return null;
    }

    @Override
    public void addGene(Genes gene) {
        genes.put(gene.toString(), gene);
    }

    @Override
    public void addGenes(List<Genes> genesList) {
        for (Genes gene : genesList) {
            genes.put(gene.toString(), gene);
        }
    }

    @Override
    public void removeGene(Genes gene) {
        genes.remove(gene.toString());
    }
}
