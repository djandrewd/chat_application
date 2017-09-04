package ua.goit.offine.controller;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.goit.offine.configuration.MvcConfiguration;
import ua.goit.offine.dao.MessageDao;
import ua.goit.offine.entity.ChatMessage;
import ua.goit.offine.entity.Messages;

/**
 * Test for chat room.
 *
 * @author Andrey Minov
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class, MvcConfiguration.class})
public class ChatRoomControllerTest {

  @Autowired
  private WebApplicationContext applicationContext;

  @Autowired
  private MessageDao messageDao;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
  }

  @Test
  public void testLastMessages() throws Exception {
    PageRequest page = new PageRequest(0, (int) 10, new Sort(DESC, "id"));
    Messages m1 = mock(Messages.class);
    when(m1.getId()).thenReturn(2L);
    Messages m2 = mock(Messages.class);
    when(m2.getId()).thenReturn(1L);

    Page<Messages> messages = mock(Page.class);
    when(messages.getContent()).thenReturn(asList(m1, m2));
    when(messageDao.findAll(page)).thenReturn(messages);
    ///
    ChatMessage cm1 = new ChatMessage(1, null, null, null);
    ChatMessage cm2 = new ChatMessage(2, null, null, null);
    mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("main"))
           .andExpect(model().attribute("messages", equalTo(asList(cm1, cm2))));

  }
}