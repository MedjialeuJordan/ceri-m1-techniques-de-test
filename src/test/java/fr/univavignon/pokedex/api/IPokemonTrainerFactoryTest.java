package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedex pokedex;
    private PokemonTrainer trainer;

    @BeforeEach
    void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedex = mock(IPokedex.class);
        trainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);

        when(trainerFactory.createTrainer("Ash", Team.VALOR, mock(IPokedexFactory.class))).thenReturn(trainer);
    }

    @Test
    void testCreateTrainer() {
        PokemonTrainer result = trainerFactory.createTrainer("Ash", Team.VALOR, mock(IPokedexFactory.class));
        assertNotNull(result);
        assertEquals("Ash", result.getName());
        assertEquals(Team.VALOR, result.getTeam());
        assertEquals(pokedex, result.getPokedex());
    }
}
