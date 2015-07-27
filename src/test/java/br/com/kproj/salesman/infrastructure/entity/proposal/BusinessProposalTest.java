package br.com.kproj.salesman.infrastructure.entity.proposal;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class BusinessProposalTest {

    @InjectMocks
    private BusinessProposal businessProposal;


    @Test
    public void shouldReturnTotal() {

        List<ProposalProductItem> productItems = getProductItems();
        businessProposal.setProductItems(productItems);

        BigDecimal total = businessProposal.getTotal();

        assertThat(total, is(new BigDecimal(25)));
    }

    private List<ProposalProductItem> getProductItems() {
        ProposalProductItem itemOne = new ProposalProductItem();
        itemOne.setPrice(BigDecimal.TEN);
        itemOne.setQuantity(2);
        ProposalProductItem itemTwo = new ProposalProductItem();
        itemTwo.setPrice(BigDecimal.ONE);
        itemTwo.setQuantity(5);

        return Lists.newArrayList(itemOne, itemTwo);
    }


}