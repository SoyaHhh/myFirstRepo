package net.thumbtack.school.library.dto.response;

import java.util.List;

public class GetBooksDtoResponse {
      private List<String> tokens;

      public GetBooksDtoResponse(List<String> tokens){
          this.tokens = tokens;
      }

    public List<String> getTokens() {
        return tokens;
    }
}
