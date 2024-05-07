package com.example.valorant_commons_ui.textview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.valorant_commons_ui.R
import com.example.valorant_commons_ui.messures.cardMediumPadding
import com.example.valorant_commons_ui.theme.AppTheme
import com.example.valorant_commons_ui.theme.ValorantViewPreviews

   @Composable
   fun CardBodyTextParagraph(text: String?, modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Justify) {
      Column (Modifier.wrapContentSize()){
         Text(
            text = text.toString(),
            modifier = modifier
               .wrapContentSize()
               .fillMaxWidth()
               .padding(horizontal = cardMediumPadding),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = textAlign,
            fontSize = 15.sp
            )
      }
   }

   @Composable
   fun CardTitleText(text: String?, modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Justify) {
      Column (Modifier.wrapContentSize()){
         Text(
            text = text.toString(),
            modifier = modifier
               .wrapContentSize()
               .fillMaxWidth()
               .padding(horizontal = cardMediumPadding),
            style = MaterialTheme.typography.titleLarge,
            textAlign = textAlign,
            fontSize = 17.sp
         )
      }
   }

@Composable
fun BodyTextParagraph(text: String?, modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Justify) {
   Column (Modifier.wrapContentSize()){
      Text(
         text = text.toString(),
         modifier = modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(horizontal = cardMediumPadding),
         style = MaterialTheme.typography.bodyMedium,
         textAlign = textAlign,
      )
   }
}
@Composable
fun TitleText(text: String?, modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Justify) {
   Column {
      Text(
         text = text.toString(),
         modifier = modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(horizontal = cardMediumPadding),
         style = MaterialTheme.typography.titleLarge,
         textAlign = textAlign,
         fontSize = 20.sp
      )
   }
}
   @ValorantViewPreviews
   @Composable
   fun ComposablePreview() {
      AppTheme{
         Surface {
            Column {
               CardTitleText(stringResource(id = R.string.sample_string_test_short))
               CardTitleText(stringResource(id = R.string.sample_string_test_long))
            }
         }
      }
   }